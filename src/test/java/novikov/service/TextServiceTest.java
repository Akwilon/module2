package novikov.service;

import novikov.bean.Leaf;
import novikov.bean.Paragraph;
import novikov.bean.Text;
import novikov.controller.Controller;
import novikov.controller.exception.ParserException;
import novikov.controller.parser.ParseCreator;
import novikov.controller.parser.ParseText;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TextServiceTest {
    private final String path = "src/main/resources/text.txt";

    @Test
    public void TestService() throws ParserException {

        Controller controller = new Controller();
        TextService service = new TextService();
        Text textSorted = controller.parseTextFromFile(path);
        for (Leaf leaf : textSorted.getLeafs()) {
            service.sortParagtaph((Paragraph)leaf).printValues();
        }
    }

}
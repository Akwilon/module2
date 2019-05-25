package novikov.service;

import novikov.bean.Leaf;
import novikov.bean.Paragraph;
import novikov.bean.Text;
import novikov.controller.Controller;
import novikov.controller.exception.ParserException;
import org.junit.Test;

public class TextServiceTest {
    private final String path = "src/main/resources/text.txt";

    @Test
    public void TestService() throws ParserException {

        Controller controller = Controller.getController();
        TextService service = new TextService();
        Text textSorted = controller.parseTextFromFile(path);
        for (Leaf leaf : textSorted.getLeafs()) {
            service.sortParagtaph((Paragraph) leaf);
        }

        textSorted.printValues();
    }

}
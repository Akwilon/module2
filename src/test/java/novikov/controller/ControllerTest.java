package novikov.controller;

import novikov.bean.Text;
import novikov.controller.exception.ParserException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {
    @Test
    public void testTextController() throws ParserException {
        String path = "src/main/resources/text.txt";
        Controller controller = new Controller();
        Text text = controller.parseTextFromFile(path);
        text.printValues();

    }

}
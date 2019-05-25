package novikov.controller;

import novikov.bean.Text;
import novikov.controller.exception.ParserException;
import novikov.controller.parser.ParseCreator;
import novikov.controller.parser.ParseText;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {

    private static Controller instanse;
    private Logger logger = LogManager.getLogger(Controller.class);

    private Controller() {
    }

    public static Controller getController() {
        if (instanse == null) {
            instanse = new Controller();
        }
        return instanse;
    }

    public Text parseTextFromFile(String path) throws ParserException {
        if (path == null || path.isEmpty()) {
            logger.error("Wrong path to File: " + path);
            throw new ParserException("Wrong path to File");
        }
        Path paths = Paths.get(path);
        String parsedString = null;
        try {
            byte[] bytesString = Files.readAllBytes(paths);
            parsedString = new String(bytesString);
        } catch (IOException e) {
            logger.error("Path parser exception : " + path + " With stackTrace: " + e);
            throw new ParserException("Path parser exception", e);
        }
        ParseText parseText = ParseCreator.createTextToWordParse();
        Text text = parseText.parseLine(parsedString);
        return text;
    }

}

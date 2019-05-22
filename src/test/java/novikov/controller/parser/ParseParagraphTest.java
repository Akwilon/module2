package novikov.controller.parser;

import novikov.bean.Paragraph;
import novikov.bean.Text;
import novikov.controller.Controller;
import novikov.controller.exception.ParserException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParseParagraphTest {

    @Test
    public void parseParagraph() throws ParserException {
        String paragraphTest = " \tIt has survived not only five centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the with the\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a\n" +
                "more-or-less normal distribution of letters, as opposed to using 'Content here, content\n" +
                "here', making it look like readable English.\n" +
                "\tIt is a established fact that a reader will be of a page when looking at its\n" +
                "layout.\n" +
                "\tBye.";


        System.out.println(paragraphTest);
        System.out.println();

         ParseText parseText = new ParseText();
        parseText
                .setNext(new ParseParagraph()
                        .setNext(new ParserSentence()
                                .setNext(new ParseWord())));

        Text text = parseText.parseLine(paragraphTest);
        text.printValues();


    }







}
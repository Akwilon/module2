package novikov.controller.parser;

public class ParseCreator {

    public static ParseText createTextToWordParse(){
        ParseText parseText = new ParseText();
        parseText.setNext(new ParseParagraph().setNext(new ParserSentence().setNext(new ParseWord())));
                return parseText;
    }
}

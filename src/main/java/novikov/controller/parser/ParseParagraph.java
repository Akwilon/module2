package novikov.controller.parser;

import novikov.bean.Leaf;
import novikov.bean.Paragraph;
import novikov.controller.exception.ParserException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class ParseParagraph extends ParserLinked<Leaf> {
    private static final Pattern SENTENCE_DEL = Pattern.compile("[.!?]\r?");
    private static final Pattern SENTENCE_END = Pattern.compile("[.!?]");
    private Logger logger = LogManager.getLogger(ParseText.class);


    @Override
    public Paragraph parseLine(String string) throws ParserException {
        if (string == null || string.isEmpty()) {
            logger.error(" Input string is null: " + string);
            throw new ParserException("Input is Empty");
        }
        List<Leaf> sentenceList = new ArrayList<>();
        String[] strings = string.trim().split(SENTENCE_DEL.pattern());
        for (String s : strings) {
            Optional<Leaf> optionalLeaf = parseNext(s);
            if (!optionalLeaf.isPresent()) {
                logger.error(" No other Parser: " + optionalLeaf.isPresent());
                throw new ParserException("No other Parser Found");
            }
            sentenceList.add(optionalLeaf.get());
        }
        Paragraph paragraph = new Paragraph(sentenceList);
        return paragraph;


    }
}

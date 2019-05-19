package novikov.controller.parser;

import novikov.bean.Leaf;
import novikov.bean.Sentence;
import novikov.controller.exception.ParserException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class ParserSentence extends ParserLinked<Leaf> {


    private final static Pattern WORD_DEL = Pattern.compile("\\s");
    private Logger logger = LogManager.getLogger(ParseText.class);

    @Override
    public Sentence parseLine(String string) throws ParserException {
        if (string == null || string.isEmpty()) {
            logger.error(" Input string is null: " + string);
            throw new ParserException("Input String is empty");
        }
        List<Leaf> wordsList = new ArrayList<>();
        String[] strings = string.trim().split(WORD_DEL.pattern());
        for (String s : strings) {
            Optional<Leaf> optionalLeaf = parseNext(s);
            if (!optionalLeaf.isPresent()){
                logger.error(" No other Parser: " + optionalLeaf.isPresent());
                throw new ParserException("No other Parser Found");
            }
            wordsList.add(optionalLeaf.get());
        }
        Sentence sentence = new Sentence(wordsList);
        return sentence;
    }
}

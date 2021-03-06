package novikov.controller.parser;

import novikov.bean.Leaf;
import novikov.bean.Paragraph;
import novikov.bean.Text;
import novikov.controller.exception.ParserException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class ParseText extends ParserLinked<Leaf> {

    private static final Pattern PAR_DELIM = Pattern.compile("\n(\\s{4,}|\t)");
    private Logger logger = LogManager.getLogger(ParseText.class);

    @Override
    public Text parseLine(String string) throws ParserException {
        if (string == null || string.isEmpty()) {
            logger.error(" Input string is null: " + string);
            throw new ParserException("Input String is empty");
        }
        List<Leaf> parList = new ArrayList<>();
        String[] strings = string.trim().split(PAR_DELIM.pattern());
        for (String s : strings) {
            Optional<Leaf> optionalLeaf = parseNext(s);
            if (!optionalLeaf.isPresent()){
                logger.error(" No other Parser: " + optionalLeaf.isPresent());
                throw new ParserException("No other Parser Found");
            }
            parList.add(optionalLeaf.get());
        }

        Text text = new Text(parList);
        return text;
    }
}

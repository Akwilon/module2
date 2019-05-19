package novikov.controller.parser;

import novikov.bean.Leaf;
import novikov.bean.Word;
import novikov.controller.exception.ParserException;

public class ParseWord implements ParserChain<Leaf> {
    @Override
    public Word parseLine(String string) throws ParserException {
        Word word = new Word(string);
        return word;
    }
}

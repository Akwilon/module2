package novikov.controller.parser;

import novikov.controller.exception.ParserException;

import java.util.List;

public interface ParserChain<T> {
    T parseLine (String string) throws ParserException;


}

package novikov.controller.parser;

import java.util.List;

public interface ParserChain<T> {
    T parseLine (String string);


}

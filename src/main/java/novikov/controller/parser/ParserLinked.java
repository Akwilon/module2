package novikov.controller.parser;

import novikov.controller.exception.ParserException;

import java.util.Optional;

public abstract class ParserLinked<T> implements ParserChain<T> {
    private ParserChain<T> next;

    public ParserChain<T> setNext(ParserChain<T> next) {
        this.next = next;
        return this;
    }

    public Optional<T> parseNext(String string) throws ParserException {
        if (next != null) {
            return Optional.ofNullable(next.parseLine(string));
        }
        return Optional.empty();
    }

}

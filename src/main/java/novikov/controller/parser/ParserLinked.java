package novikov.controller.parser;

import java.util.Optional;

public abstract class ParserLinked<T> implements ParserChain<T> {
    private ParserChain<T> next;

    public void setNext(ParserChain<T> next){
        this.next = next;
    }

    public Optional<T> parseNext(String string){
        if(next != null){
            return Optional.ofNullable(next.parseLine(string));
        }
        return Optional.empty();
    }

}

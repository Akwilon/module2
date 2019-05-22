package novikov.bean;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements CompositeLeaf {
    private List<Leaf> words = new ArrayList<>();

    public Sentence(List<Leaf> words) {
        this.words = words;
    }

    public Sentence() {

    }

    @Override
    public void addLeaf(Leaf leaf) {
        this.words.add(leaf);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sentence{");
        sb.append("words=").append(words);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public List<Leaf> getLeafs() {
        return words;
    }

    @Override
    public void printValues() {
        for (Leaf word : words) {
            System.out.print(" ");
            word.printValues();
        }
    }
}

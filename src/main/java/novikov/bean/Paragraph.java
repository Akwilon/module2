package novikov.bean;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements CompositeLeaf {
    private List<Leaf> sentences = new ArrayList<>();

    public Paragraph(List<Leaf> sentence) {
        this.sentences = sentence;
    }

    public Paragraph() {

    }

    @Override
    public void addLeaf(Leaf leaf) {
        this.sentences.add(leaf);
    }

    @Override
    public List<Leaf> getLeafs() {
        return sentences;
    }

    @Override
    public void printValues() {
        for (Leaf sentence : sentences) {
            sentence.printValues();
            System.out.println(".");
        }
    }

}

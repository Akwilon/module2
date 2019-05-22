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

    public void setSentences(List<Leaf> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Paragraph{");
        sb.append("sentences=").append(sentences);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void printValues() {

        for (Leaf sentence : sentences) {
            sentence.printValues();
            System.out.print(".");
        }
        System.out.print("\n");
    }

}

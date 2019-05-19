package сom.novikov.bean;

import novikov.bean.Leaf;
import novikov.bean.Paragraph;
import novikov.bean.Sentence;
import novikov.bean.Word;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParagraphTest {

    @Test
    public void printValues() {
        List<Leaf> sentence = new ArrayList<>();
        sentence.add(new Word("First"));
        sentence.add(new Word("second"));
        sentence.add(new Word("words!"));

        Sentence sentence1 = new Sentence(sentence);
        Word hello = new Word("Hello");
        Word java = new Word("java");
        Word year = new Word("2019!");

        Sentence sentence2 = new Sentence();
        sentence2.addLeaf(hello);
        sentence2.addLeaf(java);
        sentence2.addLeaf(year);

        Paragraph paragraph = new Paragraph();
        paragraph.addLeaf(sentence1);
        paragraph.addLeaf(sentence2);
        paragraph.printValues();

    }
}
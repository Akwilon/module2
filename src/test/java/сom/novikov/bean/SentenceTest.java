package сom.novikov.bean;

import novikov.bean.Sentence;
import novikov.bean.Word;
import org.junit.Test;

public class SentenceTest {

    @Test
    public void printValuesWords() {
        Word hello = new Word("Hello");
        Word java = new Word("java");
        Word year = new Word("2019!");

        Sentence sentence = new Sentence();
        sentence.addLeaf(hello);
        sentence.addLeaf(java);
        sentence.addLeaf(year);
        sentence.printValues();

    }
}
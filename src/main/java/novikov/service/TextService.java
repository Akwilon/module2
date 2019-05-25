package novikov.service;

import novikov.bean.Leaf;
import novikov.bean.Paragraph;
import novikov.bean.Sentence;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextService implements Service {

    @Override
    public void sortParagtaph(Paragraph text) {

        List<Leaf> sortedLeaf = text.getLeafs().stream()
                .map(sentence -> (Sentence) sentence)
                .sorted(Comparator.comparingInt(sentence -> sentence.getLeafs().size()))
                .collect(Collectors.toList());
        //Collections.reverse(sortedLeaf); ---- от большего к меньшему
        text.setSentences(sortedLeaf);
    }


}

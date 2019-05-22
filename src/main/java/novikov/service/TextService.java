package novikov.service;

import novikov.bean.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextService implements Service {

    @Override
    public Paragraph sortParagtaph(Paragraph text) {

        List<Leaf> sortedLeaf = text.getLeafs().stream()
                                .map(sentence -> (Sentence) sentence)
                                .sorted(Comparator.comparingInt(sentence -> sentence.getLeafs().size() ))
                                .collect(Collectors.toList());
        Collections.reverse(sortedLeaf);
        return new Paragraph(sortedLeaf);

    }





}

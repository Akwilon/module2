package novikov.bean;

import java.util.List;

public interface CompositeLeaf  extends Leaf{

    void addLeaf(Leaf leaf);

    List<Leaf> getLeafs();

}

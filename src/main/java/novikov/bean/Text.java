package novikov.bean;

import java.util.ArrayList;
import java.util.List;

public class Text implements CompositeLeaf {
    private List<Leaf> par = new ArrayList<>();

    public Text(List<Leaf> pars) {
        this.par = pars;
    }

    public Text() {

    }

    @Override
    public void addLeaf(Leaf leaf) {
        this.par.add(leaf);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Text{");
        sb.append("par=").append(par);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public List<Leaf> getLeafs() {
        return par;
    }

    @Override
    public void printValues() {
        for (Leaf pars : par) {
            System.out.print("\t");
            pars.printValues();
        }
    }

}

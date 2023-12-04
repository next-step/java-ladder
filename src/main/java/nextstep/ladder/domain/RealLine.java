package nextstep.ladder.domain;

import java.util.Iterator;
import java.util.List;

public class RealLine implements Iterable<Brace> {
    private final List<Brace> braces;

    public RealLine(List<Brace> braces) {
        this.braces = braces;
    }

    @Override
    public Iterator<Brace> iterator() {
        return this.braces.iterator();
    }

    public int move(int index) {
        Brace brace = braces.get(index);
        if(brace.isLeft()) {
            return index - 1;
        }

        if(brace.isRight()) {
            return index  + 1;
        }

        return index;
    }

    @Override
    public String toString() {
        return "RealLine{" +
                "braces=" + braces +
                '}';
    }

    public List<Brace> braces() {
        return this.braces;
    }
}

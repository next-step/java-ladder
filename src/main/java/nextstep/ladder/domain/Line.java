package nextstep.ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Brace> {
    private final List<Brace> braces;

    public Line(List<Brace> braces) {
        validate(braces);
        this.braces = braces;
    }

    private void validate(List<Brace> braces) {
        checkBracesSizeIsValid(braces);
    }

    private static void checkBracesSizeIsValid(List<Brace> braces) {
        if(braces == null || braces.isEmpty()) {
            throw new IllegalArgumentException("지지대는 최소 1개 이상이어야 합니다.");
        }
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
        return "Line{" +
                "braces=" + braces +
                '}';
    }

    public List<Brace> braces() {
        return this.braces;
    }

    @Override
    public Iterator<Brace> iterator() {
        return this.braces.iterator();
    }
}

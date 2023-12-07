package nextstep.ladder.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class Line implements Iterable<Brace> {
    private final List<Brace> braces;

    public Line(List<Brace> braces) {
        validate(braces);
        this.braces = braces;
    }

    private void validate(List<Brace> braces) {
        checkBracesSizeIsValid(braces);
        checkBracesNotConnected(braces);
    }

    private static void checkBracesSizeIsValid(List<Brace> braces) {
        if(braces == null || braces.isEmpty()) {
            throw new IllegalArgumentException("지지대는 최소 1개 이상이어야 합니다.");
        }
    }

    private void checkBracesNotConnected(List<Brace> braces) {
        IntStream.range(0, braces.size())
                .filter(index -> notConnected(braces, index))
                .findFirst()
                .ifPresent(index -> {
                    throw new IllegalArgumentException("사다리가 정상적으로 이어져 있지 않습니다.");
                });
    }

    private static boolean notConnected(List<Brace> braces, int index) {
        return braces.get(index).isRight() && !braces.get(index + 1).isLeft();
    }

    public int move(int index) {
        if (isLeft(index)) {
            return index - 1;
        }

        if (isRight(index)) {
            return index  + 1;
        }

        return index;
    }

    private boolean isLeft(int index) {
        return braces.get(index).isLeft();
    }

    private boolean isRight(int index) {
        return braces.get(index).isRight();
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

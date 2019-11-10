package ladder.domain;

import java.util.List;

public class Line {

    private List<Integer> numbers;

    public Line(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int i) {
        return numbers.contains(i);
    }
}

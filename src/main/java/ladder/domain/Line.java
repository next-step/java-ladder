package ladder.domain;

import java.util.List;

public class Line {

    private List<Integer> numbers;

    public Line(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

package ladder.domain;

import java.util.List;

public class Line {
    private final List<Moving> movings;

    public Line(int countOfPerson, Strategy strategy) {
        this.movings = strategy.create(countOfPerson);

    }

    public Line(List<Moving> movings) {
        this.movings = movings;
    }

    public List<Moving> getMovings() {
        return movings;
    }

    public int move(int index) {
        return movings.get(index).move();
    }
}



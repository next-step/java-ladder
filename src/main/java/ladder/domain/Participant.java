package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participant {
    private Name name;
    private int order;

    public Participant(Name name, int order) {
        this.order = order;
        this.name = name;
    }

    public static Participant of(String nameInput, int order) {
        Name name = Name.from(nameInput);
        return new Participant(name, order);
    }

    Name getName() {
        return name;
    }

    int calculateResult(Ladder ladder) {
        int result = order;

        ladder.getLines()
                .forEach(line -> calculateOrder(line, result));

        return result;
    }

    private void calculateOrder(Line line, int result) {
        Point point = line.getPoints().get(result);

        if (point.isRight()) {
            result++;
        }

        if (point.isLeft()) {
            result--;
        }
    }
}

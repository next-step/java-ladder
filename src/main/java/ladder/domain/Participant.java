package ladder.domain;

public class Participant {
    private Name name;
    private int index;

    public Participant(Name name, int index) {
        this.index = index;
        this.name = name;
    }

    public static Participant of(String nameInput, int index) {
        Name name = Name.from(nameInput);
        return new Participant(name, index);
    }

    Name getName() {
        return name;
    }

    int calculateResult(Ladder ladder) {
        int result = index;

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

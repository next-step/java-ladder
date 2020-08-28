package ladder.domain;

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

    public Name getName() {
        return name;
    }

    public void calculateResult(Ladder ladder) {
        ladder.getLines()
                .forEach(this::calculateOrder);
    }

    private void calculateOrder(Line line) {
        Point point = line.getPoints().get(order);

        if(point.isRight()) {
            order++;
        }

        if(point.isLeft()) {
            order--;
        }
    }
}

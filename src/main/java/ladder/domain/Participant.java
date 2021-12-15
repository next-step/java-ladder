package ladder.domain;

public class Participant {
    private final Name name;
    private final Position position;

    public Participant(String name, int section, int floor) {
        this(new Name(name), new Position(section, floor));
    }

    public Participant(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name.getName();
    }

    // PrizeIndex 가져오는 거임
    public int getSection() {
        return this.position.getSection();
    }

    public int getFloor() {
        return this.position.getFloor();
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}

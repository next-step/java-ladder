package ladder.domain;

public class Position {
    private final int section;
    private final int floor;

    public Position(int section, int floor) {
        this.section = section;
        this.floor = floor;
    }

    public int getSection() {
        return this.section;
    }

    public int getFloor() {
        return this.floor;
    }

    @Override
    public String toString() {
        return "Position{" +
                "section=" + section +
                ", floor=" + floor +
                '}';
    }
}

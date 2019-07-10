package ladder.model;

public class Reward {

    private final String value;
    private Position position;

    public Reward(String value, int position) {
        this.value = value;
        this.position = new Position(position);
    }

    public String getValue() {
        return value;
    }

    public Position getPosition() {
        return this.position;
    }
}

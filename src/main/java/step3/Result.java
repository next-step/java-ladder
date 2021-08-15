package step3;


public class Result {
    private final String value;
    private final Position position;

    public Result(String value, Position position) {
        this.value = value;
        this.position = position;
    }

    public String toOutputString() {
        return this.value;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }
}

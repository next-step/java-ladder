package camp.nextstep.edu.rebellion.domain.position;

public class MovedPosition {
    private final String name;
    private final int finalPosition;

    public MovedPosition(String name, int finalPosition) {
        this.name = name;
        this.finalPosition = finalPosition;
    }

    public String getName() {
        return name;
    }
    public int getFinalPosition() {
        return finalPosition;
    }
}

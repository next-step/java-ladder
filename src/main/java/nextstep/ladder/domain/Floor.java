package nextstep.ladder.domain;

public class Floor {

    public static final int MINIMUM_FLOOR = 1;
    private final int floor;

    public static Floor from(int floor) {
        return new Floor(floor);
    }

    private Floor(int floor) {
        validate(floor);
        this.floor = floor;
    }

    private void validate(int floor) {
        if (floor < MINIMUM_FLOOR) {
            throw new IllegalArgumentException("층수는 1보다 낮을 수 없습니다.");
        }
    }

    public int getFloor() {
        return this.floor;
    }
}

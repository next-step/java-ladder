package step3.domain;

public enum PointStep {
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    NONE("PASS");

    public String Direction;

    PointStep(String direction) {
        Direction = direction;
    }

    public String getDirection() {
        return Direction;
    }

}

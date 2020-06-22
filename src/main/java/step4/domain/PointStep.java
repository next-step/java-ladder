package step4.domain;

public enum PointStep {
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    NONE("PASS");

    public String Direction;

    PointStep(String direction) {
        Direction = direction;
    }

}

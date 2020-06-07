package step2.domain;

public enum Pointer {
    LEFT("LEFT"),
    RIGHT("RIGHT");

    public String Direction;

    Pointer(String direction) {
        Direction = direction;
    }

    public String getDirection() {
        return Direction;
    }

}

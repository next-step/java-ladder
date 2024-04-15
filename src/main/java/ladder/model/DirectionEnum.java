package ladder.model;

public enum DirectionEnum {
    RIGHT(1),
    LEFT(-1),
    DOWN(0);

    int movement;

    DirectionEnum(int movement) {
        this.movement = movement;
    }
}

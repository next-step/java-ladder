package ladder.domain.moving;

public enum Type {
    LEFT(Boolean.TRUE, Boolean.FALSE),
    RIGHT(Boolean.FALSE, Boolean.TRUE),
    FORWARD(Boolean.FALSE, Boolean.FALSE),
    STOP(null, null);

    private final Boolean left;
    private final Boolean right;

    Type(Boolean left, Boolean right) {
        this.left = left;
        this.right = right;
    }

    public Boolean left() {
        return left;
    }

    public Boolean right() {
        return right;
    }

}

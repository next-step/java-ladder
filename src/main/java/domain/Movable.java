package domain;

public enum Movable {
    TRUE(Boolean.TRUE), FALSE(Boolean.FALSE);

    private boolean status;

    Movable(boolean status) {
        this.status = status;
    }

    public boolean on() {
        return status;
    }

    public boolean off() {
        return !status;
    }
}

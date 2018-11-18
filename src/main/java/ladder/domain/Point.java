package ladder.domain;

public class Point {

    private boolean value;

    public Point(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (this.value) {
            return "-----|";
        }
        return "     |";
    }
}

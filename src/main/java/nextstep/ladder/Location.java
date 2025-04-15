package nextstep.ladder;

public class Location {

    private int value;

    public Location(int value) {
        validate(value);
        this.value = value;
    }

    public void move(int amount) {
        int newValue = this.value + amount;
        validate(newValue);
        this.value = newValue;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location height = (Location) o;
        return value == height.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Location 값은 0보다 작을 수 없습니다.");
        }
    }
}

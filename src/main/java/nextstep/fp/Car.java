package nextstep.fp;

import java.util.Objects;

public final class Car {

    public static final int INCREASE_STEP = 1;

    private final String name;
    private final int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public final Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            return new Car(name, position + INCREASE_STEP);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, position);
    }
}

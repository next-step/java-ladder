package nextstep.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {
    private final String name;
    private final int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(MoveStrategy moveStrategy) {
//               List<String> str = new List<String>();
//        MoveStrategy ms = new MoveStrategy() {
//            @Override
//            public boolean isMovable() {
//                return false;
//            }
//        };
//
//        MoveStrategy ms1 = ()-> false;

        if (moveStrategy.isMovable()) {
            return new Car(name, position + 1);
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

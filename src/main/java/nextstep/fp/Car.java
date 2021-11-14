package nextstep.fp;

import java.util.Objects;

public class Car {
	private final String name;
	private final int position;

	public Car(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public Car move(MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			return new Car(name, position + 1);
		}
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Car car = (Car)obj;
		return position == car.position && Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}

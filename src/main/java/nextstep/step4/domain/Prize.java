package nextstep.step4.domain;

import java.util.Objects;

public class Prize {

	private final String value;

	public Prize(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Prize prize = (Prize)o;
		return Objects.equals(value, prize.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}

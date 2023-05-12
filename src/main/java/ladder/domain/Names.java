package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Names {

	private static final String DELIMITER = ",";
	public static final int LENGTH_MAXIMUM = 5;

	private final List<Name> names = new ArrayList<>();

	public Names(String inputNames) {
		Arrays.stream(inputNames.trim().split(Names.DELIMITER))
			.map(String::trim)
			.forEach(e -> {
				Name name = new Name(e);
				if (this.isExist(name)) {
					throw new IllegalArgumentException("이미 존재하는 이름입니다.");
				}
				this.names.add(name);
			});
	}

	public int countOfPerson() {
		return this.names.size();
	}

	public Name indexOf(int index) {
		return this.names.get(index);
	}

	public boolean isExist(Name name) {
		return this.names.stream().anyMatch(e -> e.equals(name));
	}

	public List<Name> getNames() {
		return this.names;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Names names1 = (Names)o;
		return Objects.equals(names, names1.names);
	}

	@Override
	public int hashCode() {
		return Objects.hash(names);
	}
}

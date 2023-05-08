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
			.forEach(name -> this.names.add(new Name(name)));
	}

	public int countOfPerson() {
		return this.names.size();
	}

	public Name indexOf(int index) {
		return this.names.get(index);
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

package ladder.domain;

import java.util.Optional;

public class Gamer {
	private static final String INSTANTIATE_ERROR_FORMAT = "Gamer of instantiate fail. name must be at least 1 character and 5 characters : name=%s";
	private final String name;

	private Gamer(String name) {
		this.name = name;
	}

	public static Gamer of(String name) {
		return Optional.ofNullable(name)
				.filter(nameString -> nameString.length() <= 5)
				.filter(nameString -> !nameString.isEmpty())
				.map(Gamer::new)
				.orElseThrow(() -> new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, name)));
	}

	public String getName() {
		return name;
	}
}

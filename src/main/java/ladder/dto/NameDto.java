package ladder.dto;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameDto {

	public static final String SPACE_NAME = " ";
	private static final int LIMIT_LENGTH = 6;
	private final String name;

	private NameDto(String name) {
		this.name = name;
	}

	public static NameDto of(String name) {
		return new NameDto(name);
	}

	public String value() {
		return Stream.generate(() -> SPACE_NAME)
			.limit(LIMIT_LENGTH - name.length())
			.collect(Collectors.joining())
			.concat(name);
	}
}

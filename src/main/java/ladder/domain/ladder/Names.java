package ladder.domain.ladder;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Names {

	private static final String DELIMITER = ",";
	private static final String TO_STRING_DELIMITER = "  ";
	private final List<Name> names;

	public static Names of(List<Name> names) {
		return new Names(names);
	}

	public static Names of(String namesString) {
		if (StringUtils.isEmpty(namesString)) {
			throw new IllegalArgumentException("이름을 입력해주세요.");
		}
		String[] namesArray = namesString.split(DELIMITER);

		if (namesArray.length == 1) {
			throw new IllegalArgumentException("이름은 두명 이상 입력해주세요.");
		}
		return Names.of(Stream.of(namesArray)
							  .map(name -> Name.of(name))
							  .collect(toList()));
	}

	@Override
	public String toString() {
		return names.stream()
					.map(Name::getName)
					.collect(joining(TO_STRING_DELIMITER));
	}

	public int getSize() {
		return names.size();
	}
}

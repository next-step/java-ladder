package ladder.domain.ladder;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Names {

	private static final String DELIMITER = ",";
	private static final String TO_STRING_DELIMITER = "  ";
	private static final String ALL_NAME = "all";
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

	public int getSize() {
		return names.size();
	}

	public Name getNameOf(int index) {
		return names.get(index);
	}

	public List<Integer> getIndexesOf(Name name) {
		if (name.equals(Name.of(ALL_NAME))) {
			return IntStream.range(0, names.size())
							.boxed()
							.collect(toList());
		}
		return Arrays.asList(IntStream.range(0, names.size())
									  .filter(i -> names.get(i)
														.equals(name))
									  .findFirst()
									  .orElseThrow(() -> new IllegalArgumentException("해당하는 이름이 존재하지 않습니다."))
							);
	}

	@Override
	public String toString() {
		return names.stream()
					.map(name -> name.toString())
					.collect(joining(TO_STRING_DELIMITER));
	}
}

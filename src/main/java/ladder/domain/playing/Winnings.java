package ladder.domain.playing;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Winnings {

	private static final String DELIMITER = ",";
	private static final String TO_STRING_DELIMITER = "  ";
	private final List<Winning> winnings;

	public static Winnings of(List<Winning> winnings) {
		return new Winnings(winnings);
	}

	public static Winnings of(String winningNames, int count) {
		if (StringUtils.isEmpty(winningNames)) {
			throw new IllegalArgumentException("실행결과를 입력해주세요.");
		}
		String[] winningNamesArray = winningNames.split(DELIMITER);

		if (winningNamesArray.length != count) {
			throw new IllegalArgumentException("실행결과 개수는 사람수와 동일해야 합니다.");
		}

		return Winnings.of(Stream.of(winningNamesArray)
								 .map(Winning::of)
								 .collect(toList()));
	}

	public Winning getWinningOf(int index) {
		return winnings.get(index);
	}

	public int getSize() {
		return winnings.size();
	}

	@Override
	public String toString() {
		return winnings.stream()
					   .map(Winning::toString)
					   .collect(joining(TO_STRING_DELIMITER));
	}
}

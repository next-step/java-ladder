package ladder.domain.ladder;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import ladder.domain.line.LadderLine;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LadderFactory {
	public static Ladder create(LadderArgument argument) {
		List<LadderLine> lines = IntStream.range(0, argument.getHeight())
										  .mapToObj(i -> LadderLine.init(argument.getWidth()))
										  .collect(toList());
		return Ladder.of(lines);
	}
}

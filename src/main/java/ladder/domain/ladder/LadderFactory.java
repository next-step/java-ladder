package ladder.domain.ladder;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import ladder.domain.line.Line;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LadderFactory {
	public static Ladder create(LadderArgument argument) {
		List<Line> lines = IntStream.range(0, argument.getHeight())
									.mapToObj(i -> Line.of(argument.getWidth()))
									.collect(toList());
		return Ladder.of(lines);
	}
}

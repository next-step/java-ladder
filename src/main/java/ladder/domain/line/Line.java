package ladder.domain.line;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

	private final List<Step> steps;

	private Line(List<Step> steps) {
		validateConsecutiveLine(steps);
		this.steps = steps;
	}

	public static Line of(List<Step> steps) {
		return new Line(steps);
	}

	public static Line of(int playersCount) {
		List<Boolean> generatedLine = LineGenerator.generate(playersCount - 1);
		List<Step> steps = generatedLine.stream()
		                                .map(Step::valueOf)
		                                .collect(Collectors.toList());
		return of(steps);
	}

	public static Line valueOf(List<Boolean> steps) {
		return of(steps.stream()
		               .map(Step::valueOf)
		               .collect(Collectors.toList()));
	}

	public static Line of(Boolean... steps) {
		List<Step> collect = Arrays.stream(steps)
		                           .map(Step::valueOf)
		                           .collect(Collectors.toList());
		return of(collect);
	}

	private void validateConsecutiveLine(List<Step> steps) {
		if (hasConsecutiveLine(steps)) {
			throw new LineContinuousException();
		}
	}

	private boolean hasConsecutiveLine(List<Step> steps) {
		return IntStream.range(0, steps.size() - 1)
		                .anyMatch(i -> steps.get(i).isConsecutiveSteps(steps.get(i + 1)));
	}

	public List<Step> getPoints() {
		return Collections.unmodifiableList(steps);
	}

	public int size() {
		return steps.size();
	}

	public boolean hasNext(int index) {
		if (index == size()) {
			return false;
		}
		return steps.get(index).value();
	}

	public boolean hasPrevious(int index) {
		if (index == 0) {
			return false;
		}
		return steps.get(index - 1).value();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Line line = (Line) o;
		return Objects.equals(steps, line.steps);
	}

	@Override
	public int hashCode() {
		return Objects.hash(steps);
	}

}

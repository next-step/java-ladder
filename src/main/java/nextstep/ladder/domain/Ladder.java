package nextstep.ladder.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import nextstep.ladder.generator.Generator;
import nextstep.ladder.util.CollectionUtils;

public class Ladder {
	private static final String EMPTY_MESSAGE = "Line 리스트가 비어있습니다.";

	private final List<Line> lines;

	private Ladder(List<Line> lines) {
		validateSize(lines);
		this.lines = new ArrayList<>(lines);
	}

	private void validateSize(List<Line> lines) {
		if (CollectionUtils.isEmpty(lines)) {
			throw new IllegalArgumentException(EMPTY_MESSAGE);
		}
	}

	public static Ladder create(List<Line> lines) {
		return new Ladder(lines);
	}

	public static Ladder initialize(Generator generator, int width, int height) {
		return Stream.generate(() -> Line.create(generator, width))
			.limit(height)
			.collect(collectingAndThen(toList(), Ladder::create));
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(lines);
	}

	public int move(int index) {
		for (Line line : lines) {
			index = line.move(index);
		}
		return index;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Ladder ladder = (Ladder)obj;

		return Objects.equals(lines, ladder.lines);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lines);
	}

	@Override
	public String toString() {
		return "Ladder{" +
			"lines=" + lines +
			'}';
	}
}

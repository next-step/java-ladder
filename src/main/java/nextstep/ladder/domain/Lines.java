package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nextstep.ladder.domain.strategy.FirstLineGenerator;
import nextstep.ladder.domain.strategy.LastLineGenerator;
import nextstep.ladder.domain.strategy.MiddleLineGenerator;

public class Lines {
	private final List<Line> lines;

	public Lines(List<Line> lines) {
		this.lines = lines;
	}

	public Lines(Width width, Height height) {
		lines = new ArrayList<>();
		lines.add(new Line(new FirstLineGenerator(height)));
		// indent 개선
		for (int idx = 1; idx < width.width(); idx++) {
			if (idx == width.width() - 1) {
				lines.add(new Line(new LastLineGenerator(lines.get(idx - 1).points())));
			}
			lines.add(new Line(new MiddleLineGenerator(lines.get(idx - 1).points())));
		}
	}

	public List<Line> lines() {
		return Collections.unmodifiableList(lines);
	}
}

package ladder.domain.line;

import java.util.Collections;
import java.util.List;

public class LadderLines {

	private final List<LadderLine> lines;

	public LadderLines(List<LadderLine> lines) {
		this.lines = lines;
	}

	public int size() {
		return lines.size();
	}

	public List<LadderLine> getContent() {
		return Collections.unmodifiableList(lines);
	}
}

package ladder.domain.line;

import ladder.domain.LadderInput;
import ladder.domain.point.FirstPoint;

public class FirstLine extends Line {

	public FirstLine(LadderInput ladderInput) {
		for (String name : ladderInput.getNames()) {
			points.add(new FirstPoint(name));
		}
	}

}

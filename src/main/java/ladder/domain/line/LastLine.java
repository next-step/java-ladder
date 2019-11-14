package ladder.domain.line;

import ladder.domain.LadderInput;
import ladder.domain.point.LastPoint;

public class LastLine extends Line{

	public LastLine(LadderInput ladderInput) {
		for (String eachResult : ladderInput.getResult()) {
			points.add(new LastPoint(eachResult));
		}
	}

}

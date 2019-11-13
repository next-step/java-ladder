package ladder.domain.line;

import ladder.domain.Participants;
import ladder.domain.point.LastPoint;

public class LastLine extends Line{

	public LastLine(Participants participants) {
		for (int i = 0, end = participants.count(); i < end; i++) {
			points.add(new LastPoint());
		}
	}

}

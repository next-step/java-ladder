package ladder.domain.line;

import ladder.domain.Participants;
import ladder.domain.point.FirstPoint;

public class FirstLine extends Line {

	public FirstLine(Participants participants) {
		for (String name : participants.getNames()) {
			points.add(new FirstPoint(name));
		}
	}

}

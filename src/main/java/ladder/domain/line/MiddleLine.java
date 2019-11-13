package ladder.domain.line;

import ladder.domain.Participants;
import ladder.domain.point.MiddlePoint;
import ladder.domain.policy.PointConnectPolicy;

public class MiddleLine extends Line {

	public MiddleLine(PointConnectPolicy policy, Participants participants) {
		for (int i = 0, end = participants.count(); i < end; i++) {
			points.add(new MiddlePoint());
		}
		connectPointsHorizontally(policy);
	}

	public MiddleLine(PointConnectPolicy policy, String[] names) {
		for (int i = 0, end = names.length; i < end; i++) {
			points.add(new MiddlePoint());
		}
		connectPointsHorizontally(policy);
	}

	private void connectPointsHorizontally(PointConnectPolicy policy) {
		for (int i = 0, end = points.size() - 1; i < end; i++) {
			getPoint(i).connectWithPointHorizontally(policy, getNextPoint(i));
		}
	}

}

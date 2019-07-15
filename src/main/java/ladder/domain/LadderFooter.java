package ladder.domain;

import java.util.List;

class LadderFooter {
	private List<String> goals;

	public LadderFooter(List<String> goals) {
		this.goals = goals;
	}

	public String getGoal(int railNumber) {
		return goals.get(railNumber);
	}
}

package ladder.domain;

import ladder.exception.NotFoundPlayer;

import java.util.List;
import java.util.stream.Collectors;

public class LadderContext {

	private List<String> goals;

	private List<String> playerNames;

	private Ladder ladder;

	public LadderContext(List<String> playerNames, List<String> goals, Ladder ladder) {
		this.goals = goals;
		this.playerNames = playerNames;
		this.ladder = ladder;
	}

	public String getGoal(String playerName){
		int railNumber = getPlayerRailNumber(playerName);
		int result = ladder.getResult(railNumber);
		return goals.get(result);
	}

	private int getPlayerRailNumber(String playerName){
		int index = this.playerNames.indexOf(playerName);

		if(index < 0){
			throw new NotFoundPlayer();
		}

		return index;
	}

	public List<NameGoalPair> getResult() {
		return this.playerNames.stream()
				.map(name -> new NameGoalPair(name, this.getGoal(name)))
				.collect(Collectors.toList());
	}
}

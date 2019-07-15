package ladder.domain;

import ladder.exception.NotFoundPlayer;
import ladder.model.NameGoalPair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class LadderHeader {

	private Map<String, Integer> playerRailMap;

	private LadderBody ladderBody;

	public LadderHeader(List<String> playerNames, LadderBody ladderBody) {
		this.ladderBody = ladderBody;
		this.playerRailMap = new HashMap<>();
		for(int i = 0; i < playerNames.size(); i++){
			this.playerRailMap.put(playerNames.get(i), i);
		}
	}

	public String getGoal(String playerName){
		Integer railNumber = playerRailMap.get(playerName);

		if(railNumber == null){
			throw new NotFoundPlayer();
		}

		return ladderBody.getResult(railNumber);
	}

	public List<NameGoalPair> getResult() {
		return this.playerRailMap.entrySet()
				.stream()
				.sorted(Comparator.comparingInt(entry -> entry.getValue()))
				.map(entry -> new NameGoalPair(entry.getKey(), this.getGoal(entry.getKey())))
				.collect(Collectors.toList());
	}

	public LadderBody getBody() {
		return this.ladderBody;
	}
}

package study3.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
	private Map<Player, Reward> resultMap = new HashMap<>();
	
	public Results(Map<Player, Reward> resultMap) {
		this.resultMap = resultMap;
	}
			
	public Results(Players players, Ladder ladder, Rewards rewards) {
		
	}

	private Results of(Players players, Ladder ladder, Rewards rewards) {
		return new Results(playGame(players, ladder, rewards));
	}

	private Map<Player, Reward> playGame(Players players, Ladder ladder, Rewards rewards) {
		
		int numberOfPlayer = players.getPlayersCount();
		
		for(int i=0; i < numberOfPlayer; i++) {
			
			Player siglePlayerName = players.getPlayers().get(i);
			Reward singleReward = findFinalPosition(siglePlayerName, ladder.getLadder(), rewards);
			
			resultMap.put(siglePlayerName, singleReward);
		}
		
		return null;
	}

	private static Reward findFinalPosition(Player siglePlayerName,List<Line> ladder, Rewards rewards) {
		
		int position = Players.findPlayersIndex(siglePlayerName);
		
		for(Line line : ladder) {
			position = line.move(position);
			System.out.println("포지션"+position);
		}
		
		return rewards.getReward(position);
	}
	
	public Map<Player, Reward> getResults() {
		return Collections.unmodifiableMap(resultMap);
	}
	
}

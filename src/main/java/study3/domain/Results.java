package study3.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
	
	private Players players;
	private LadderLine ladder;
	private Rewards rewards;
	
	private static Map<Player, String> resultMap = new HashMap<>();
	
	public Results(Map<Player, String> resultMap) {
		this.resultMap = resultMap;
	}
			
	public Results(Players players, LadderLine ladder, Rewards rewards) {
		this.players = players;
		this.ladder = ladder;
		this.rewards = rewards;
	}

	public static Results ofAll(Players players, LadderLine ladder, Rewards rewards) {
		return new Results(playGame(players, ladder, rewards));
	}

	private static Map<Player, String> playGame(Players players, LadderLine ladder, Rewards rewards) {
		
		int numberOfPlayer = players.getPlayersCount();
		
		for(int i=0; i < numberOfPlayer; i++) {
			
			Player siglePlayerName = players.getPlayers().get(i);
			String singleReward = findFinalPosition(siglePlayerName, ladder.getLadder(), rewards);
			
			resultMap.put(siglePlayerName, singleReward);
		}
		
		return resultMap;
	}

	private static String findFinalPosition(Player siglePlayerName,List<Line> ladder, Rewards rewards) {
		
		int position = Players.findPlayersIndex(siglePlayerName);
		
		for(Line line : ladder) {
			position = line.move(position);			
		}		
		return rewards.getReward(position);
	}
	
	public Map<Player, String> getResults() {
		return Collections.unmodifiableMap(resultMap);
	}	
}

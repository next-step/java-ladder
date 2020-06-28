package study3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
	private Map<Player, String> resultMap = new HashMap<>();
	
	public Results(Map<Player, String> resultMap) {
		this.resultMap = resultMap;
	}
	
	public Map<Player, String> getResult() {
		return resultMap;
	}
	
	private static Results of(Players players, Ladder ladder, String[] resultSlapOrMoney) {
		return new Results(playGame(players, ladder, resultSlapOrMoney));
	}

	private static Map<Player, String> playGame(Players players, Ladder ladder, String[] resultSlapOrMoney) {
		
		int numberOfPlayer = players.getPlayersCount();
		
		for(int i=0; i < numberOfPlayer; i++) {
			
			Player siglePlayerName = players.getPlayers().get(i);
			String resultReward = findFinalPosition(siglePlayerName, ladder.getLadder());
			
		//	resultMap.put(siglePlayerName, resultReward);
		}
		
		return null;
	}

	private static String findFinalPosition(Player siglePlayerName,List<Line> ladder) {
		
		int position = Players.findPlayersIndex(siglePlayerName);
		
		for(Line line : ladder) {
			position = line.move(position);
			System.out.println("포지션"+position);
		}
		
		return null;
	}

	
}

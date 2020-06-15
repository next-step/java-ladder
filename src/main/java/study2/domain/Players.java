package study2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

	List<Player> players;
	
	public Players(List<String> names) {
		this.players = createPlayers(names);
	}

	private List<Player> createPlayers(List<String> names) {
		
		namesLimiation(names);
		
		return names.stream()
				.map(Player::new)
				.collect(Collectors.toList());
	}

	private void namesLimiation(List<String> names) {
		if("".equals(names) || names == null ) {
			throw new IllegalArgumentException("최소한 1명 이상이 필요합니다.");
		}
		
	}

	public int getPlayersCount() {
		return this.players.size();
	}
	
}

package study2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.platform.commons.util.StringUtils;

public class Players {

	private static final String empty = " ";
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
	
	public List<String> getPlayers() {
		
		return players.stream()
				.map(Player::getPlayerName)
				.collect(Collectors.toList());
			
		// java8사용중입니다.
				//.collect(Collectors.joining(String.join("", Collections.nCopies(4, empty))));
	}
}

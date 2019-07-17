package ladder.domain;

import ladder.exception.NotFoundPlayer;
import ladder.model.PlayerRailPair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 게임참가자 명단과 배정된 레일번호를 관리하는 저장소
 */
class PlayerEntry {
	public static final int MAX_LENGTH_OF_NAME = 5;

	private Map<String, Integer> playerRailMap;

	public PlayerEntry(){
		playerRailMap = new HashMap<>();
	}

	public void append(String playerName){

		if(playerName == null || playerName.isEmpty()){
			throw new IllegalArgumentException("참가자 이름은 필수이며 1글자 이상입니다.");
		}

		if(playerName.length() > MAX_LENGTH_OF_NAME){
			throw new IllegalArgumentException("참가자 이름은 5글자를 넘을 수 없습니다.");
		}

		playerRailMap.put(playerName, playerRailMap.size());
	}

	public List<PlayerRailPair> entries() {
		return playerRailMap.entrySet()
				.stream()
				.sorted(Comparator.comparingInt(entry -> entry.getValue()))
				.map(entry -> new PlayerRailPair(entry.getKey(), entry.getValue()))
				.collect(Collectors.toList());
	}

	public PlayerRailPair getEntry(String playerName) {
		Integer railNumber = playerRailMap.get(playerName);

		if(railNumber == null){
			throw new NotFoundPlayer();
		}

		return new PlayerRailPair(playerName, railNumber);
	}
}

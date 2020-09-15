package step4.domain;

import java.util.*;
import java.util.stream.Collectors;

public class GameResult {
	private final Map<String, String> gameResult;

	private GameResult(Map<String, String> gameResult) {
		this.gameResult = gameResult;
	}

	public static GameResult init(String[] names, String[] results) {
		Map<String, String> gameResult = new LinkedHashMap<>();
		for (int i = 0; i < names.length; i++) {
			gameResult.put(names[i], results[i]);
		}
		return new GameResult(gameResult);
	}

	public void putAll(List<String> names, List<String> results) {
		for (int i = 0; i < results.size(); i++) {
			gameResult.put(names.get(i), results.get(i));
		}
	}

	public int size() {
		return gameResult.size();
	}

	public List<String> values() {
		return new ArrayList<>(gameResult.values());
	}

	public List<String> allResult() {
		return gameResult.keySet().stream()
				.map(key -> key + " : " + gameResult.get(key))
				.collect(Collectors.toList());
	}

	public String getResultOf(String name) {
		if(!gameResult.containsKey(name)) {
			throw new IllegalArgumentException("입력하신 이름은 참여자 목록에 없습니다. : " + name);
		}
		return gameResult.get(name);
	}
}

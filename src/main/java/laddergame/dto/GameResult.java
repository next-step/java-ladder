package laddergame.dto;

import laddergame.exception.LadderGameException;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class GameResult {

	private static final String PLEASE_INPUT_PARTICIPANT_NAME = "참가자를 찾을 수 없습니다. 게임에 참여한 사람의 이름을 입력해주세요.";

	private final Map<String, String> gameResult;

	public GameResult(Map<String, String> gameResults) {
		this.gameResult = gameResults;
	}

	public Set<Map.Entry<String, String>> getAllGameResult() {
		return gameResult.entrySet();
	}

	public String  getResultOfSpecificOne(String name) {
		return Optional.ofNullable(gameResult.get(name))
				.orElseThrow(() -> new LadderGameException(PLEASE_INPUT_PARTICIPANT_NAME));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GameResult that = (GameResult) o;
		return gameResult.equals(that.gameResult);
	}

	@Override
	public int hashCode() {
		return Objects.hash(gameResult);
	}
}

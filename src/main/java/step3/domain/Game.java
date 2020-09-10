package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class Game {
	private static final String GAMEOVER_USERNAME = "all";
	
	private final Ladder ladder;
	private GameResults results;

	public Game(String[] names) {
		this.ladder = new Ladder(new Users(names));
	}

	public void setGameResult(String[] results) {
		this.results = GameResults.of(results);
		validResultSize();
	}

	private void validResultSize() {
		if (this.results.size() != ladder.getUsersName().size()) {
			throw new IllegalArgumentException("실행 결과 수는 입력한 참여자 수와 같아야 합니다.");
		}
	}
	
	public Ladder start(int height) {
		return this.ladder.makeLadder(height);
	}
	
	public Map<String, String> getAllUserResult() {
		Map<String, String> resultMap = new HashMap<>();
		for (int i = 0; i < results.size(); i++) {
			resultMap.put(ladder.getUserName(i), results.getResultOf(i));
		}
		
		return resultMap;
	}
	
	public String getUserResult(String name) {
		if (!ladder.containUser(name) && !GAMEOVER_USERNAME.equals(name)) {
			throw new IllegalArgumentException("입력하신 이름은 참여자 목록에 없습니다.");
		}
		return results.getResultOf(ladder.getUserPositionOf(name));
	}
}

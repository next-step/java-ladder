package step4.domain;

import java.util.List;

public class Game {
	private final Ladder ladder;
	private final GameResult result;

	public Game(String[] names, String[] results) {
		validResultSize(names, results);
		this.ladder = new Ladder(new Users(names));
		this.result = GameResult.init(names, results);
	}

	private void validResultSize(String[] names, String[] results) {
		if (names.length != results.length) {
			throw new IllegalArgumentException("실행 결과 수는 입력한 참여자 수와 같아야 합니다.");
		}
	}
	
	public Ladder start(int height) {
		Ladder ladder = this.ladder.makeLadder(height);
		result.putAll(ladder.getAllUserName(), result.values());
		return ladder;
	}
	
	public List<String> getAllUserResult() {
		return result.allResult();
	}
	
	public String getUserResult(String name) {
		return result.getResultOf(name);
	}
}

package step3.domain;

public class Game {
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
	
	public String getUserResult(String name) {
		if (!ladder.containUser(name)) {
			throw new IllegalArgumentException("입력하신 이름은 참여자 목록에 없습니다.");
		}
		return results.getResultOf(ladder.getUserPositionOf(name));
	}
}

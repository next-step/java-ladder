package step3.domain;

public class Game {
	private final Ladder ladder;
	private GameResult result;

	public Game(String[] names) {
		this.ladder = new Ladder(new Users(names));
	}

	public void setGameResult(String[] results) {
		/////////////////
		this.result = GameResult.of(results);
		/////////////////
		this.result = GameResult.of(ladder.getUsersName(), results);
		validResultSize();
	}

	private void validResultSize() {
		if (this.result.size() != ladder.getUsersName().size()) {
			throw new IllegalArgumentException("실행 결과 수는 입력한 참여자 수와 같아야 합니다.");
		}
	}
	
	public Ladder start(int height) {
		Ladder ladder = this.ladder.makeLadder(height);
		this.result.calculateResult(ladder);
		return ladder;
	}
}

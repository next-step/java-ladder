package nextstep.ladder.domain;

public class LadderResultDeterminer {

	private final LadderResult ladderResult;
	private final Names names;

	public LadderResultDeterminer(final LadderResult ladderResult, final Names names) {
		validate(ladderResult, names);
		this.ladderResult = ladderResult;
		this.names = names;
	}

	public int getStartColumn(final Name name) {
		return names.findStartColumn(name);
	}

	public String getResultByIndex(final int index) {
		return ladderResult.getResultByIndex(index);
	}

	private void validate(final LadderResult ladderResult, final Names names) {
		if (ladderResult.getResultNumber() != names.getNumberOfNames()) {
			throw new IllegalArgumentException("실행 결과의 개수가 참여자의 수와 일치하지 않습니다.");
		}
	}
}

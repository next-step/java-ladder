package nextstep.ladder.domain;

public class LadderResult {
	private final Participant participant;
	private final Reward reward;

	public LadderResult(Participant participant, Reward reward) {
		this.participant = participant;
		this.reward = reward;
	}

	public Participant participant() {
		return this.participant;
	}

	public Reward reward() {
		return this.reward;
	}
}

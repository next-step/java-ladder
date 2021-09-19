package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
	private final Ladder ladder;
	private final Participants participants;
	private final Rewards rewards;

	public LadderGame(Participants participants, Rewards rewards, int maximumHeight) {
		this.ladder = new Ladder(participants.countOfPerson(), maximumHeight);
		this.participants = participants;
		this.rewards = rewards;
	}

	public Ladder ladder() {
		return this.ladder;
	}

	public void play() {
		participants.playLadder(this.ladder);
	}

	public LadderResult gameResult(String name) {
		Participant participant = this.participants.findByName(name);

		return new LadderResult(participant, this.rewards.findByPosition(participant.position()));
	}

	public List<LadderResult> gameResultAll() {
		return this.participants.participants()
			.stream()
			.map(participant -> new LadderResult(participant,
				this.rewards.findByPosition(participant.position())))
			.collect(Collectors.toList());
	}
}

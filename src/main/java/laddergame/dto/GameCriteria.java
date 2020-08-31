package laddergame.dto;

import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.participant.Participants;
import laddergame.domain.result.Prizes;

public class GameCriteria {

	private final Participants participants;
	private final Prizes prizes;
	private final LadderHeight ladderHeight;

	public GameCriteria(Participants participants, Prizes prizes, LadderHeight ladderHeight) {
		this.participants = participants;
		this.prizes = prizes;
		this.ladderHeight = ladderHeight;
	}

	public Participants getParticipants() {
		return participants;
	}

	public Prizes getPrizes() {
		return prizes;
	}

	public LadderHeight getLadderHeight() {
		return ladderHeight;
	}
}

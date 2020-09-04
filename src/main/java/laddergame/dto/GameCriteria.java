package laddergame.dto;

import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.prize.Prizes;

import java.util.Collection;
import java.util.Set;

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

	public Set<Participant> getParticipantsAsCollection() {
		return participants.getParticipants();
	}

	public Collection<String> getPrizesAsCollection() {
		return prizes.getPrizeNames();
	}

	public Prizes getPrizes() {
		return prizes;
	}

	public LadderHeight getLadderHeight() {
		return ladderHeight;
	}
}

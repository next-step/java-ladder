package nextstep.ladder.domain;

public class Ladder {
	private final Participants participants;
	private final Lines lines;

	public Ladder(Participants participants, Lines lines) {
		this.participants = participants;
		this.lines = lines;
	}

	public Ladder(Participants participants, Height height)  {
		this.participants = participants;
		this.lines = new Lines(new Width(participants.num()), height);
	}

	public Participants participants() {
		return participants;
	}

	public Lines lines() {
		return lines;
	}
}

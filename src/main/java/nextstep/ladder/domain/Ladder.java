package nextstep.ladder.domain;

public class Ladder {
	private final Participants participants;
	private final Rows rows;

	public Ladder(Participants participants, Rows rows) {
		this.participants = participants;
		this.rows = rows;
	}

	public Ladder(Participants participants, Height height)  {
		this.participants = participants;
		this.rows = new Rows(new Width(participants.num()), height);
	}

	public Participants participants() {
		return participants;
	}

	public Rows rows() {
		return rows;
	}
}

package nextstep.ladder.exception;

import nextstep.ladder.domain.Participant;

@SuppressWarnings("serial")
public class ParticipantNameSizeException extends IllegalArgumentException {
	public ParticipantNameSizeException() {
		super(String.format("참가자 이름은 최대 %d자리 까지만 가능합니다.", Participant.SIZE_OF_NAME));
	}
}

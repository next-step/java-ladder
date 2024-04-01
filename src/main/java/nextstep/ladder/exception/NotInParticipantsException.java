package nextstep.ladder.exception;

import nextstep.ladder.domain.Participant;

import java.text.MessageFormat;
import java.util.Set;
import java.util.stream.Collectors;

public class NotInParticipantsException extends IllegalArgumentException {
    public NotInParticipantsException(Set<Participant> participants, String name) {
        super(MessageFormat.format("참가자 목록에 없는 이름입니다. (참가자 목록: {0}, 입력된 이름: {1})",
                participants.stream()
                        .map(Participant::getName)
                        .collect(Collectors.toUnmodifiableList()),
                name));
    }
}

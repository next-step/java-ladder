package nextstep.ladder.view.output;

import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.view.OutPutViewUtils;

import java.util.stream.Collectors;

public class ParticipantsOutputView {

    public void appendParticipantsName(Participants participants, StringBuilder stringBuilder) {
        String paddingAddedParticipantsName = participants.stream()
                .map(Participant::getName)
                .map(OutPutViewUtils::appendPaddingBeforeValue)
                .collect(Collectors.joining(""));

        stringBuilder.append(paddingAddedParticipantsName);
    }
}

package com.seok2.ladder.user.domain;

import com.seok2.ladder.user.dto.ParticipantsDTO;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class ParticipantsAssembler {

    public static ParticipantsDTO assemble(Participants participants) {

        return participants.getParticipants().stream()
                .map(ParticipantAssembler::assemble)
                .collect(collectingAndThen(toList(), ParticipantsDTO::new));
    }

}

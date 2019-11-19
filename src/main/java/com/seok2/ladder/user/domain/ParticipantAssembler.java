package com.seok2.ladder.user.domain;

import com.seok2.ladder.user.dto.ParticipantDTO;

public class ParticipantAssembler {

    private ParticipantAssembler() {
    }

    static ParticipantDTO assemble(Participant participants) {
        return new ParticipantDTO(participants.getName());
    }

}

package com.seok2.ladder.user.dto;

import java.util.Collections;
import java.util.List;

public class ParticipantsDTO {

    private final List<ParticipantDTO> participantDTOs;

    public ParticipantsDTO(List<ParticipantDTO> participantDTOs) {
        this.participantDTOs = Collections.unmodifiableList(participantDTOs);
    }

    public List<ParticipantDTO> getParticipants() {
        return participantDTOs;
    }
}

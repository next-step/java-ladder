package com.seok2.ladder.user.dto;

import java.util.Collections;
import java.util.List;

public class ParticipantsDTO {

    private final List<ParticipantDTO> participants;

    public ParticipantsDTO(List<ParticipantDTO> participants) {
        this.participants = Collections.unmodifiableList(participants);
    }

    public List<ParticipantDTO> getParticipants() {
        return participants;
    }
}

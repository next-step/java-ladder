package com.seok2.ladder.user.domain;

import com.seok2.ladder.structure.domain.Pillar;

public class Player {

    private final Participant participant;
    private final Pillar pillar;

    private Player(Participant participant, Pillar pillar) {
        this.participant = participant;
        this.pillar = pillar;
    }

    public static Player of(Participant participant, Pillar pillar) {
        return new Player(participant, pillar);
    }

    public Pillar descend() {
        Pillar current = pillar;
        while (current.isNotBottom()) {
            current = current.next();
        }
        return current;
    }

    public Participant getParticipant() {
        return participant;
    }
}

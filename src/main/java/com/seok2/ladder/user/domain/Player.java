package com.seok2.ladder.user.domain;

import com.seok2.ladder.structure.domain.Pillar;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(getParticipant(), player.getParticipant()) &&
            Objects.equals(pillar, player.pillar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParticipant(), pillar);
    }
}

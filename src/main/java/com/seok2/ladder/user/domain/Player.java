package com.seok2.ladder.user.domain;

import com.seok2.ladder.structure.domain.Line;

public class Player {

    private final Participant participant;
    private final Line line;

    private Player(Participant participant, Line line) {
        this.participant = participant;
        this.line = line;
    }

    public static Player of(Participant participant, Line line) {
        return new Player(participant, line);
    }

    public Line descend() {
        Line current = line;
        while(current.isNotBottom()){
            current = current.next();
        }
        return current;
    }
}

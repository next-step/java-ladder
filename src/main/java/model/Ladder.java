package model;

import generator.LadderGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> lines;
    private List<Participant> participants;

    public Ladder(String names, Positive height, LadderGenerator ladderGenerator) {
        participants = Participant.getParticipants(names);
        lines = ladderGenerator.getLines(height, participants.size());
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

}

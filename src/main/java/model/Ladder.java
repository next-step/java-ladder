package model;

import generator.LadderGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<Line>();
    private List<Participant> participants = new ArrayList<Participant>();


    public Ladder(String names, String height, LadderGenerator ladderGenerator) {
        participants = ladderGenerator.getParticipants(names);
        lines = ladderGenerator.getLines(height, participants.size());
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}

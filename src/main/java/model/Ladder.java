package model;

import generator.LineGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines = new ArrayList<Line>();
    private List<Participant> participants = new ArrayList<Participant>();


    public Ladder(String names, String maxHeight, LineGenerator lineGenerator) {
        participants = lineGenerator.getParticipants(names);
        lines = lineGenerator.getLines(participants.size());

        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            int size = line.getPoints().size();
            for (int j = 0; j < size; j++) {
            }
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}

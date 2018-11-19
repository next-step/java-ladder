package model;

import generator.LadderGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<Line>();
    private List<Participant> participants = new ArrayList<Participant>();


    public Ladder(String names, String height, LadderGenerator ladderGenerator) {
        participants = Participant.getParticipants(names);
        lines = ladderGenerator.getLines(height, participants.size());
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public static Positive move(List<Line> lines, Positive x, Positive y) {
        if (y.getNum() == 0) {
            return x;
        }

        int num = x.getNum();
        Line line = lines.get(lines.size() - y.getNum());

        if (line.hasLine(num)) {
            return moveRightDown(lines, x, y);
        }

        if (line.hasLeftLine(x)) {
            return moveLeftDown(lines, x, y);
        }

        return moveDown(lines, x, y);
    }

    private static Positive moveDown(List<Line> lines, Positive x, Positive y) {
        return move(lines, x, y.decrease());
    }

    private static Positive moveLeftDown(List<Line> lines, Positive x, Positive y) {
        return move(lines, x.decrease(), y.decrease());
    }

    private static Positive moveRightDown(List<Line> lines, Positive x, Positive y) {
        return move(lines, x.increase(), y.decrease());
    }


}

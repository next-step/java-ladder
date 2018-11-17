package generator;

import model.Line;
import model.Participant;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    public List<Participant> getParticipants(String names) {
        ArrayList<Participant> participants = new ArrayList<>();

        for (String name : split(names)) {
            participants.add(new Participant(name));
        }

        return participants;
    }

    public List<Line> getLines(Integer length) {
        ArrayList<Line> lines = new ArrayList<Line>();
        for (int i = 0; i <= length; i++) {
            lines.add(Line.of(length));
        }
        return lines;
    }

    private String[] split(String participants) {
        return participants.split(",");
    }
}

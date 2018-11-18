package generator;

import model.Line;
import model.Participant;
import model.Positive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLadderGenerator implements LadderGenerator {

    private static final String COMMA = ",";

    @Override
    public List<Participant> getParticipants(String names) {
        return Arrays.stream(split(names))
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Line> getLines(String height, int countOfPerson) {
        ArrayList<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < Positive.of(height).getNum(); i++) {
            lines.add(Line.of(Positive.of(countOfPerson).getNum()));
        }

        lines.forEach(Line::addAutoLines);

        return lines;
    }

    @Override
    public String[] split(String participants) {

        return participants.split(COMMA);
    }
}

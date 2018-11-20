package generator;

import model.Line;
import model.Participant;
import model.Positive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLadderGenerator implements LadderGenerator {
    @Override
    public List<Line> getLines(Positive height, int countOfPerson) {
        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < height.getNum(); i++) {
            lines.add(Line.of(Positive.of(countOfPerson).getNum()));
        }

        lines.forEach(Line::addAutoLines);

        return lines;
    }
}

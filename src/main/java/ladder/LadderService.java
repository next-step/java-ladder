package ladder;

import ladder.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LadderService {

    public Lines createLines(int countOfLine, int countOfPerson) {
        List<Line> linesWithPoint = new ArrayList<>();
        for (int i = 0; i < countOfLine; i++) {
            linesWithPoint.add(new LineShuffleGenerator().generate(countOfPerson));
        }
        return new Lines(linesWithPoint);
    }
}

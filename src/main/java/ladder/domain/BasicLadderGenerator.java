package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class BasicLadderGenerator implements LadderGenerator{

    private int countOfLine;
    private int countOfPerson;

    public BasicLadderGenerator(int countOfLine, int countOfPerson) {
        this.countOfLine = countOfLine;
        this.countOfPerson = countOfPerson;
    }

    @Override
    public List<Line> generate() {
        List<Line> linesWithPoint = new ArrayList<>();
        for (int i = 0; i < countOfLine; i++) {
            linesWithPoint.add(new LineShuffleGenerator().generate(countOfPerson));
        }
        return new ArrayList<>(linesWithPoint);
    }
}

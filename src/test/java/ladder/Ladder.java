package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {

    private final LadderData ladderData;
    private final List<Line> lineList = new ArrayList<>();

    public Ladder(LadderData ladderData) {
        this.ladderData = ladderData;
    }

    public void makeLadder() {

        int nameLength = ladderData.getNames().length;

        for (int i = 0; i < ladderData.getHeight(); i++) {
            Line line = new Line(nameLength);
            line.makeRow();
            lineList.add(line);
        }
    }

    public void printLadder() {
        Arrays.stream(ladderData.getNames())
                .forEach(name -> System.out.print(name + "\t"));
        System.out.println();
        lineList.forEach(Line::printRow);
    }
}

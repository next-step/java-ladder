package laddergame.domain;

import laddergame.service.LadderLinesGenerator;

import java.util.List;

public class LadderLines {

    private final List<LadderLine> ladderLines;

    public LadderLines(int sizeOfPerson, int height) {
        ladderLines = LadderLinesGenerator.generate(sizeOfPerson, height);
    }

    public int move(int startPointIndex) {
        int curIndex = startPointIndex;

        for(LadderLine line : ladderLines) {
            curIndex = line.move(curIndex);
        }

        return curIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ladderLines.forEach(line -> {
            sb.append(line);
            sb.append("\n");
        });

        String returnString = sb.toString();
        return returnString.substring(0, returnString.lastIndexOf('\n'));
    }
}
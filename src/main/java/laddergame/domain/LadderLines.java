package laddergame.domain;

import laddergame.service.LadderLinesGenerator;

import java.util.List;

public class LadderLines {

    private final List<LadderLine> ladderLines;

    public LadderLines(int sizeOfPerson, int height) {
        ladderLines = LadderLinesGenerator.generate(sizeOfPerson, height);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ladderLines.forEach(line -> {
            sb.append(line);
            sb.append("\n");
        });

        return sb.toString();
    }
}
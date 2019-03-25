package laddergame.domain;

import laddergame.service.LadderLinesGenerator;

import java.util.List;

public class LadderLines {

    private final List<LadderLine> ladderLines;

    public LadderLines(int sizeOfPerson, int height) {
        ladderLines = LadderLinesGenerator.generate(sizeOfPerson, height);
    }

    public String toResultString() {
        StringBuilder sb = new StringBuilder();

        ladderLines.forEach(line -> {
            sb.append(line.toResultString());
            sb.append("\n");
        });

        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LadderLines{");
        sb.append("ladderLines=").append(ladderLines);
        sb.append('}');
        return sb.toString();
    }
}
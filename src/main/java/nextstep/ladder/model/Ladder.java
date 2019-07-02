package nextstep.ladder.model;

import nextstep.ladder.view.LineFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder init(int countOfHeight, int sizeOfPerson) {
        List<LadderLine> ladderLines = new ArrayList<>();
        IntStream.range(0, countOfHeight)
                .forEach(n -> ladderLines.add(LadderLine.init(sizeOfPerson)));
        return new Ladder(ladderLines);
    }

    public String getFormattedLine() {
        LineFormatter lineFormatter = new LineFormatter();
        return ladderLines.stream()
                .map(lineFormatter::format)
                .collect(Collectors.joining());
    }

    public int moveToResult(int position) {
        for (LadderLine ladderLine : ladderLines) {
            position = ladderLine.move(position);
        }
        return position;
    }
}

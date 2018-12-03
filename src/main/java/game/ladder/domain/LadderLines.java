package game.ladder.domain;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLines {

    private final Height height;
    private final List<LadderLine> ladderLines;

    public LadderLines(Height height, int sizeOfPerson) {
        this.height = height;
        ladderLines = ImmutableList.copyOf(initLines(sizeOfPerson));
    }

    public LadderLines(List<LadderLine> ladderLines) {
        Preconditions.checkArgument(!ladderLines.isEmpty(), "하나이상의 LadderLine이 필요합니다.");
        this.height = new Height(ladderLines.size());
        this.ladderLines = ladderLines;
    }

    private List<LadderLine> initLines(final int sizeOfPerson) {
        return IntStream.range(0, height.getValue())
                .mapToObj(i -> LadderLine.init(sizeOfPerson))
                .collect(Collectors.toList());
    }

    public Height getHeight() {
        return this.height;
    }

    public int width() {
        return this.ladderLines.size();
    }

    public String getStringLadderLines() {
        return this.ladderLines.stream().map(LadderLine::getStringLadderLine).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator();
    }

    public Position computeResultPosition(Position position) {
        int result = position.getValue();
        for (LadderLine ladderLine : ladderLines) {
            result = ladderLine.move(result);
        }
        return new Position(result);
    }
}
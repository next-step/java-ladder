package laddergame.domain.ladder;

import laddergame.domain.vo.Column;
import laddergame.domain.vo.Position;
import laddergame.domain.vo.Height;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final Height ladderHeight;
    private final List<Line> lines;

    public Ladder(Height ladderHeight, int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        this.ladderHeight = ladderHeight;
        this.lines = createLines(ladderHeight.getHeight(), numberOfPlayer, connectGenerator);
    }

    private List<Line> createLines(int ladderHeight, int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(i + 1, numberOfPlayer, connectGenerator));
        }

        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Column progressAllStep(Column column) {
        Position position = new Position(column.getColumn());

        while (position.getHeight() <= ladderHeight.getHeight()) {
            Line currentLine = findCurrentLine(position);
            position = currentLine.movePosition(position);
        }

        return position.column();
    }

    public Line findCurrentLine(Position position) {
        return lines.stream()
                .filter(line -> line.isSameHeight(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("현재 높이에 맞는 사다리 한 라인이 존재하지 않습니다. - " +
                        position.getHeight()));
    }
}

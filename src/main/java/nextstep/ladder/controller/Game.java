package nextstep.ladder.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import nextstep.ladder.module.Board;
import nextstep.ladder.module.BoardResult;
import nextstep.ladder.module.Height;
import nextstep.ladder.module.Line;
import nextstep.ladder.module.Name;
import nextstep.ladder.module.NameList;
import nextstep.ladder.module.PointList;
import nextstep.ladder.module.ResultList;

public class Game {

    private final NameList peopleNames;
    private final ResultList resultNames;
    private final Height height;

    public Game(NameList peopleNames, ResultList resultNames, Height height) {
        this.peopleNames = peopleNames;
        this.resultNames = resultNames;
        this.height = height;
        validateGame();
    }

    public Board createBoard() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(new Line(new PointList(peopleNames.size())));
        }
        lines.forEach(Line::createLadders);
        return new Board(lines, peopleNames);
    }

    private void validateGame() {
        if (peopleNames.size() != resultNames.size()) {
            throw new IllegalArgumentException("사람 이름과 결과 이름의 개수가 다릅니다.");
        }
    }

    public BoardResult play(Board board) {
        Map<Name, Integer> resultMap = new HashMap<>();
        IntStream.range(0, peopleNames.size())
                .forEach(i -> {
                    Name name = peopleNames.get(i);
                    resultMap.put(name, i);
                });
        for (Line line : board.lines()) {
            IntStream.range(0, peopleNames.size())
                    .forEach(i -> {
                        Name name = peopleNames.get(i);
                        resultMap.put(name, move(resultMap.get(name), line));
                    });
        }

        return new BoardResult(resultMap, resultNames);
    }

    private int move(int index, Line line) {
        if (canMoveLeft(index, line)) {
            return index - 1;
        }
        if (canMoveRight(index, line)) {
            return index + 1;
        }
        return index;
    }

    private boolean canMoveLeft(int index, Line line) {
        return line.points().get(index).leftBridge().isBuilt();
    }

    private boolean canMoveRight(int index, Line line) {
        return line.points().get(index).rightBridge().isBuilt();
    }
}

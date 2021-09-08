package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameColumns {
    private List<LadderGameColumn> ladderGameColumns;

    public LadderGameColumns(Name name) {
        ladderGameColumns = name.getParticipantNames()
                .stream()
                .map(s -> new LadderGameColumn(name.getParticipantNames().indexOf(s), s))
                .collect(Collectors.toList());
    }

    public void runLadder(int height, Ladder ladder) {
        for (int i = 0; i < height; i++) {
            Line line = ladder.getLines().get(i);
            runGameByFloor(line);
        }
    }

    private List<LadderGameColumn> runGameByFloor(Line line) {
        return ladderGameColumns.stream()
                .map(ladderGameColumn -> gameByPosition(line, ladderGameColumn))
                .collect(Collectors.toList());
    }

    private LadderGameColumn gameByPosition(Line line, LadderGameColumn ladderGameColumn) {
        int index = ladderGameColumn.getPosition();
        // 현재 포지션에서 왼쪽에 사다리가 존재하면서, 연결 라인이 있을 때, 왼쪽으로 위치 이동
        if (leftMoveStrategy(line, index)) {
            ladderGameColumn.moveLeft();
            return ladderGameColumn;
        }
        // 현재 포지션에서 오른쪽에 사다리가 존재하면서, 연결 라인이 있을 때, 오른쪽으로 위치 이동
        if (rightMoveStrategy(line, index)) {
            ladderGameColumn.moveRight();
            return ladderGameColumn;
        }
        // 좌, 우에 사다리가 존재하지 않거나, 연결 라인이 없을 때 현재 포지션을 고수한다.
        return ladderGameColumn;
    }

    private boolean rightMoveStrategy(Line line, int index) {
        return index < ladderGameColumns.size() - 1 && line.getPoints().get(index);
    }

    private boolean leftMoveStrategy(Line line, int index) {
        return index - 1 >= 0 && line.getPoints().get(index - 1);
    }

    public void calculateResult(Results results) {
        ladderGameColumns.stream()
                .map(ladderGameColumn -> addResultInToLadderGameColumns(ladderGameColumn, results))
                .collect(Collectors.toList());
    }

    private LadderGameColumn addResultInToLadderGameColumns(LadderGameColumn ladderGameColumn, Results results) {
        int position = ladderGameColumn.getPosition();
        String result = results.resultOfPosition(position);
        return ladderGameColumn;
    }

    public List<LadderGameColumn> getLadderGameList() {
        return ladderGameColumns;
    }
}
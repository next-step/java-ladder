package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameColumns {
    private List<LadderGameColumn> ladderGameColumns;

    public LadderGameColumns(Name name) {
        name.getParticipantNames()
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

    private void runGameByFloor(Line line) {
        ladderGameColumns.stream()
                .map(ladderGameColumn -> gameByColumn(line, ladderGameColumn))
                .collect(Collectors.toList());
    }

    private LadderGameColumn gameByColumn(Line line, LadderGameColumn ladderGameColumn) {
        int index = ladderGameColumn.getPosition();
        if (leftMoveStrategy(index, line)) {
            ladderGameColumn.moveLeft();
            return ladderGameColumn;
        }
        if (rightMoveStrategy(line, index)) {
            ladderGameColumn.moveRight();
            return ladderGameColumn;
        }
        // 좌, 우에 사다리가 존재하지 않거나, 연결 라인이 없을 때 현재 포지션을 고수한다.
        return ladderGameColumn;
    }

    private boolean rightMoveStrategy(Line line, int index) {
        // 현재 포지션에서 오른쪽에 사다리가 존재하면서, 연결 라인이 있을 때, 오른쪽으로 위치 이동
        return index < ladderGameColumns.size() - 1 && line.getPoints().get(index);
    }

    private boolean leftMoveStrategy(int index, Line line) {
        // 현재 포지션에서 왼쪽에 사다리가 존재하면서, 연결 라인이 있을 때, 왼쪽으로 위치 이동
        return index - 1 >= 0 && line.getPoints().get(index);
    }

    public void calculateResult(Result results) {
        ladderGameColumns = ladderGameColumns.stream()
                .map(ladderGameColumn -> addResultInToLadderGameColumns(ladderGameColumn, results))
                .collect(Collectors.toList());
    }

    private LadderGameColumn addResultInToLadderGameColumns(LadderGameColumn ladderGameColumn, Result results) {
        int position = ladderGameColumn.getPosition();
        String result = results.getItems().get(position);
        ladderGameColumn.setResult(result);
        return ladderGameColumn;
    }

    public List<LadderGameColumn> getLadderGameList() {
        return ladderGameColumns;
    }
}

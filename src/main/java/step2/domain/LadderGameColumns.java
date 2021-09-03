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
            ladderGameColumns = runGameByFloor(line);
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
        if (index - 1 >= 0 && line.getPoints().get(index - 1)) {
            return new LadderGameColumn(index - 1, ladderGameColumn.getName());
        }
        // 현재 포지션에서 오른쪽에 사다리가 존재하면서, 연결 라인이 있을 때, 오른쪽으로 위치 이동
        if (index < ladderGameColumns.size() - 1 && line.getPoints().get(index)) {
            return new LadderGameColumn(index + 1, ladderGameColumn.getName());
        }
        // 좌, 우에 사다리가 존재하지 않거나, 연결 라인이 없을 때 현재 포지션을 고수한다.
        return ladderGameColumn;
    }

    public void calculateResult(Result results) {
        ladderGameColumns = ladderGameColumns.stream()
                .map(ladderGameColumn -> addResultInToLadderGameColumns(ladderGameColumn, results))
                .collect(Collectors.toList());
    }

    private LadderGameColumn addResultInToLadderGameColumns(LadderGameColumn ladderGameColumn, Result results) {
        int position = ladderGameColumn.getPosition();
        String result = results.getItems().get(position);
        return new LadderGameColumn(position, ladderGameColumn.getName(), result);
    }
}

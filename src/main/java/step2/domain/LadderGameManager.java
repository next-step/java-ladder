package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameManager {
    private List<LadderGameColumn> ladderGameColumns;

    public LadderGameManager(Name name) {
        ladderGameColumns = name.getParticipantNames()
                .stream()
                .map(s -> new LadderGameColumn(name.getParticipantNames().indexOf(s), s))
                .collect(Collectors.toList());
    }

    public List<LadderGameColumn> getLadderGames() {
        return ladderGameColumns;
    }

    public void runGame(int height, Ladder ladder) {
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

    private LadderGameColumn moveStrategy(int index, Line line, LadderGameColumn ladderGameColumn) {
        if (index - 1 >= 0 && index - 1 < ladderGameColumns.size() - 1 && line.getPoints().get(index - 1)) {
            return new LadderGameColumn(index - 1, ladderGameColumn.getName());
        }
        if (index >= 0 && index < ladderGameColumns.size() - 1 && line.getPoints().get(index)) {
            return new LadderGameColumn(index + 1, ladderGameColumn.getName());
        }
        return new LadderGameColumn(index, ladderGameColumn.getName());
    }

    private LadderGameColumn gameByPosition(Line line, LadderGameColumn ladderGameColumn) {
        return moveStrategy(ladderGameColumn.getPosition(), line, ladderGameColumn);
    }

    public void calResult(Result results) {
        for (int i = 0; i < ladderGameColumns.size(); i++) {
            int position = ladderGameColumns.get(i).getPosition();
            String name = ladderGameColumns.get(i).getName();
            String result = results.getStrings().get(ladderGameColumns.get(i).getPosition());
            ladderGameColumns.set(i, new LadderGameColumn(position, name, result));
        }
    }
}
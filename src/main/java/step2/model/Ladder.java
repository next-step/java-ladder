package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static step2.model.LadderValidator.isBlank;

public class Ladder {
    private static final int MIN_LADDER_HIGH = 1;

    private List<Line> lines;

    public Ladder(String high, int numberOfUser, ValueStrategy valueStrategy) {
        isBlank(high);
        isOverMinHigh(high);
        generateLine(parseInt(high), numberOfUser, valueStrategy);
    }

    private int parseInt(String high) {
        return Integer.parseInt(high.trim());
    }

    private void isOverMinHigh(String high) {
        if (parseInt(high) < MIN_LADDER_HIGH) {
            throw new IllegalArgumentException("최소" + MIN_LADDER_HIGH + "이상 입력해주세요");
        }
    }

    private void generateLine(int ladderHigh, int numberOfUser, ValueStrategy valueStrategy) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < ladderHigh; i++) {
            lines.add(new Line(numberOfUser, valueStrategy));
        }

    }

//    public List<List<Boolean>> getLadder() {
//        return lines.stream()
//                        .map(Line::getLine)
//                        .collect(Collectors.toList());
//    }

    public GameResults runGame(Users users, Results results) {
        int column = users.getNumberOfUsers();
        List<Result> gameResults = new ArrayList<>();

        for (int i = 0; i < column; i++) {
            int columnIndex = i;
            columnIndex = crossLadder(lines.size(), columnIndex);
            gameResults.add(results.getResult(columnIndex));
        }

        return new GameResults(users, new Results(gameResults));
    }

    private int crossLadder(int high, int columnIndex) {
        for (int i = 0; i < high; i++) {
            columnIndex = lines.get(i).checkPoint(columnIndex);
        }

        return columnIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}

package step2.domain;

import step2.dto.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final List<Line> lines;

    public Lines(int numberOfPerson, int height) {
        this.lines = Stream.generate(() -> new Line(numberOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }

    public Lines(List<Line> lineList) {
        this.lines = lineList;
    }

    public Results play(Players players) {
        List<Result> resultList = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            resultList.add(new Result(players.player(i), this.move(i)));
        }
        return new Results(resultList);
    }

    public int move(int startIndex) {
        Position position = new Position(startIndex);
        for (Line line : lines) {
            position = line.movable(position);
        }
        return position.getWidthIndex();
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : lines) {
            stringBuilder.append(line.print());
        }
        return stringBuilder.toString();
    }


    @Override
    public String toString() {
        return "Lines{" +
                "lines=" + lines +
                '}';
    }
}

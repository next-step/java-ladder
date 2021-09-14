package step2.domain;

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

    public Results play(int numberOfPerson) {
        List<Result> resultList = new ArrayList<>();
        for (int i = 0; i < numberOfPerson; i++) {
            resultList.add(new Result(i, this.move(i)));
        }
        return new Results(resultList);
    }

    public int move(int startIndex) {
        int startLineIndex = 0;
        String movable = lines.get(startLineIndex).movable(startIndex);

        while (startLineIndex < lines.size() - 1) {
            if (movable.equals("left")) {
                startLineIndex = startLineIndex + 1;
                startIndex = startIndex - 1;
                movable = lines.get(startLineIndex).movable(startIndex);
            } else if (movable.equals("right")) {
                startLineIndex = startLineIndex + 1;
                startIndex = startIndex + 1;
                movable = lines.get(startLineIndex).movable(startIndex);
            } else {
                startLineIndex = startLineIndex + 1;
                movable = lines.get(startLineIndex).movable(startIndex);
            }
        }

        if (movable.equals("left")) {
            return startIndex - 1;
        } else if (movable.equals("right")) {
            return startIndex + 1;
        }
        return startIndex;
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

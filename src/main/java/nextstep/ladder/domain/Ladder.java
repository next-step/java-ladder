package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder random(int countOfPersons, int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이여야 합니다.");
        }
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> Line.random(countOfPersons))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }

    public List<Line> getLines() {
        return lines;
    }

    public void getResultOfUser(int col) {
        int row = 0;
        int height = lines.size();
        int width = lines.get(0).getPoints().size();
        while (true) {
            Line nowLine = lines.get(row);
            Point leftPoint = null;
            Point rightPoint = nowLine.getPoints().get(col);
            if (col - 1 >= 0) {
                leftPoint = nowLine.getPoints().get(col - 1);
            }
            if (rightPoint.isExist()) {
                if (col + 1 <= width) {
                    col++;
                }
            } else if (leftPoint != null && leftPoint.isExist()) {
                col--;
            }

            System.out.println(String.format("%d : %d", row, col));
            if (row + 1 == height) {
                break;
            }
            System.out.println(String.format("%d : %d", row, col));
            row++;
        }
    }
}

package nextstep.ladder;

import nextstep.ladder.view.ResultView;

import java.util.Objects;
import java.util.Random;

public class Line {
    private static final Random random = new Random();

    private final RandomNum randomNum;

    private String lines;

    public Line(int maxNum, RandomNum randomNum) {
        this.randomNum = randomNum;
        this.lines = drawLine(maxNum);
    }

    private String drawLine(int maxNum) {
        lines = "    |";

        for (int i = 1; i < maxNum; i++) {
            int randomNumber = randomNum.generateRandomNumber();
            oddOrEven(() -> randomNumber % 2 == 0);
        }

        return lines;
    }

    private String oddOrEven(AddLines addLines) {
        if (addLines.draw()) {
            return previousCheck(() -> lines.charAt(lines.length() - 2) == '-');
        }
        return lines += ResultView.addNoneLine();
    }

    private String previousCheck(AddLines addLines) {

        if (addLines.draw()) {
            return lines += ResultView.addNoneLine();
        }
        return lines += ResultView.addLine();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(lines, line.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}

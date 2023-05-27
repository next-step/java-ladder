package ladder.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private Points poins = new Points();

    private List<Boolean> points = new ArrayList<>();

    public void calculatorLine(int countOfPerson) {
        poins.calculatorLine(countOfPerson);
    }

    public void moveLine(Player player) {
        int result = player.getResult();

        if (isResultPullRight(result)) {
            player.moveLeft(points);
            return;
        }

        if (isResultPullLeft(result)) {
            player.moveRight(points);
            return;
        }
        player.connectResult(points);
    }


    boolean isResultPullRight(int result) {
        return result >= points.size();
    }

    boolean isResultPullLeft(int result) {
        return result <= 0;
    }

    public List<Boolean> getLine() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}

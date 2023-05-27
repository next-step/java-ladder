package ladder.domain.model;

import java.util.List;

public class Line {
    private Points points = new Points();
    public void calculatorLine(int countOfPerson) {
        points.calculatorLine(countOfPerson);
    }

    public void movePlayer(Player player) {
        int result = player.getResult();

        if (isResultPullRight(result)) {
            player.moveLeft(points.getPoints());
            return;
        }

        if (isResultPullLeft(result)) {
            player.moveRight(points.getPoints());
            return;
        }
        player.move(points.getPoints());
    }


    boolean isResultPullRight(int result) {
        return result >= points.getPoints().size();
    }

    boolean isResultPullLeft(int result) {
        return result <= 0;
    }

    public List<Boolean> getLine() {
        return points.getPoints();
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points.getPoints() +
                '}';
    }
}

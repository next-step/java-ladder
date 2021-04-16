package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class LadderController {

    public static final String SPLIT_COMMA = ",";

    public static List<Player> getPlayers() {
        return Arrays.stream(InputView.getPlayers().split(SPLIT_COMMA))
                .map(Player::new)
                .collect(toList());
    }

    public static int getHeight() {
        return InputView.getLadderHeight();
    }

    public static Lines createLines(int size, int height) {
        PointsGeneration pointsGeneration = new PointsGeneration(size-1);

        return IntStream.range(0, height)
                .mapToObj(index -> getLine(pointsGeneration))
                .collect(collectingAndThen(toList(), Lines::new));
    }

    private static Line getLine(PointsGeneration pointsGeneration) {
        PointCondition pointCondition = new PointCondition();
        List<Boolean> points = pointsGeneration.getPoints(pointCondition);

        return new Line(points);
    }

    public static void showResult(List<Player> players, Lines lines) {
        ResultView.printPlayer(players);
        printLadder(lines);
    }

    private static void printLadder(Lines lines) {
        lines.getLines().forEach(line -> {
            ResultView.printLadderStart();
            ResultView.printLadder(line);
            ResultView.printLadderEnd();
        });
    }
}

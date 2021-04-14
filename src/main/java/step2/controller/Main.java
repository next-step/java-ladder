package step2.controller;

import step2.domain.LadderGeneration;
import step2.domain.Line;
import step2.domain.Player;
import step2.domain.PointCondition;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static final String SPLIT_COMMA = ",";

    public static void main(String[] args) {
        List<Player> players = Arrays.stream(InputView.getPlayers().split(SPLIT_COMMA))
                .map(Player::new)
                .collect(Collectors.toList());
        LadderGeneration ladderGeneration = new LadderGeneration(players.size()-1);

        List<Line> lines = IntStream.range(0, InputView.getLadderHeight())
                .mapToObj(index -> getLine(ladderGeneration))
                .collect(Collectors.toList());

        ResultView.printPlayer(players);
        ResultView.printLadder(lines);
    }

    private static Line getLine(LadderGeneration ladderGeneration) {
        PointCondition pointCondition = new PointCondition(false);
        List<Boolean> points = ladderGeneration.getPoints(pointCondition);

        return new Line(points);
    }
}

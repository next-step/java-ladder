package camp.nextstep.edu.rebellion.domain;

import camp.nextstep.edu.rebellion.domain.ladder.Ladder;
import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.reward.RewardResult;
import camp.nextstep.edu.rebellion.domain.reward.RewardResults;
import camp.nextstep.edu.rebellion.domain.reward.Rewards;
import camp.nextstep.edu.rebellion.domain.rule.DrawingRule;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private static final  int INIT_INDEX = 0;
    private static final String COMMAND_ALL = "all";

    private final int rows;
    private final Players players;
    private final Rewards rewards;
    private final Ladder ladder;

    public LadderGame(Players players, Rewards rewards, int rows) {
        checkSize(players, rewards);

        this.players = players;
        this.rewards = rewards;
        this.rows = rows;
        this.ladder = new Ladder(rows, players.getCountOfPlayers());
    }

    public Ladder make(DrawingRule drawingRule) {
        IntStream
                .range(INIT_INDEX, rows)
                .forEach(row -> draw(row, drawingRule));
        return ladder;
    }

    public RewardResults run(String name) {
        return players.getPlayers()
                .stream()
                .filter(p -> COMMAND_ALL.equals(name) || p.match(name))
                .map(p -> new RewardResult(p.getName(), getRunningResult(p.getPosition())))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        RewardResults::new));
    }

    public String getRunningResult(int startingPoint) {
        return rewards.findNameByPosition(
                ladder.getFinalPosition(startingPoint));
    }

    private void checkSize(Players players, Rewards rewards) {
        if (players.getCountOfPlayers() != rewards.getCountOfRewards()) {
            throw new IllegalArgumentException("참가자 수와 당첨결과 수가 일치하지 않습니다");
        }
    }

    private void draw(int positionOfRow, DrawingRule drawingRule) {
        IntStream
                .range(INIT_INDEX, players.getCountOfPlayers() - 1)
                .forEach(col -> {
                    if (drawingRule.canDraw()) {
                        ladder.drawLine(positionOfRow, col);
                    }
                });
    }
}

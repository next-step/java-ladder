package camp.nextstep.edu.rebellion.refactoring;

import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.reward.RewardResult;
import camp.nextstep.edu.rebellion.domain.reward.RewardResults;
import camp.nextstep.edu.rebellion.domain.reward.Rewards;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String COMMAND_ALL = "all";

    private final Players players; // LadderGame 이 굳이 가지고 있을 필요가 없음
    private final Rewards rewards; // LadderGame 이 굳이 가지고 있을 필요가 없음
    private final Ladder ladder;

    public LadderGame(Players players, Rewards rewards, int rows) {
        this.players = players;
        this.rewards = rewards;
        this.ladder = new Ladder(rows, players.getCountOfPlayers());
    }

    public RewardResults run(String name) {
        return players.getPlayers()
                .stream()
                .filter(p -> COMMAND_ALL.equals(name) || p.match(name))
                .map(p -> new RewardResult(p.getName(), ladder.getFinalPosition(p.getPosition())))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        RewardResults::new));
    }
}

package camp.nextstep.edu.rebellion.refactoring;

import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.reward.Rewards;

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

    public MovedPositions run(String name) {
        // 별도의 결과를 전달하는 객체를 만듬
        // Rewards 의존성은 제거
        // 이름과 최종 포지션만 가지고 있는 객체
        // ResultGenerator 에서 RewardResults 를 생성 하는 역할을 위임
        return players.getPlayers()
                .stream()
                .filter(p -> COMMAND_ALL.equals(name) || p.match(name))
                .map(p -> new MovedPosition(p.getName(), ladder.getFinalPosition(p.getPosition())))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        MovedPositions::new));
    }
}

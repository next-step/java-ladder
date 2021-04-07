package nextstep.ladder.domain;

import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.dto.LadderBoardDto;
import nextstep.ladder.dto.LadderGameReport;
import nextstep.ladder.dto.PlayerDto;
import nextstep.ladder.dto.RewardDto;
import nextstep.ladder.util.Pair;

import java.util.function.Predicate;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderGame {

    private static final String ALL = "all";

    private final Players players;
    private final LadderBoard ladderBoard;

    public LadderGame(Players players, LadderBoard ladderBoard) {
        this.players = players;
        this.ladderBoard = ladderBoard;
    }

    public LadderGameReport getResult(String name) {
        Predicate<Player> query = name.equals(ALL) ? ignored -> true : player -> player.hasName(name);

        return getResult(query);
    }

    private LadderGameReport getResult(Predicate<Player> playerQuery) {
        return players.getResult(ladderBoard, playerQuery)
                      .stream()
                      .map(pair -> makeResultPair(pair.getFirst(), pair.getSecond()))
                      .collect(collectingAndThen(toList(), LadderGameReport::new));
    }

    private Pair<PlayerDto, RewardDto> makeResultPair(Player player, Reward reward) {
        return new Pair<>(player.export(), reward.export());
    }

    public LadderBoardDto exportLadderBoard() {
        return ladderBoard.export();
    }

}

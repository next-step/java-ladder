package nextstep.ladder.domain;

import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.dto.LadderBoardDto;
import nextstep.ladder.dto.LadderGameReport;
import nextstep.ladder.dto.PlayerDto;
import nextstep.ladder.dto.PlayerNamesDto;

import java.util.Collections;

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

    public LadderGameReport makeResultReport(String playerName) {
        return playerName.equals(ALL) ? getAllResults() : getResult(playerName);
    }

    private LadderGameReport getAllResults() {
        return players.stream()
                      .map(player -> PlayerDto.of(player, ladderBoard.getReward(player.getLane())))
                      .collect(collectingAndThen(toList(), LadderGameReport::new));
    }

    private LadderGameReport getResult(String playerName) {
        Player player = players.getPlayerBy(playerName);

        PlayerDto playerDto = PlayerDto.of(player, ladderBoard.getReward(player.getLane()));

        return new LadderGameReport(Collections.singletonList(playerDto));
    }

    public LadderBoardDto exportLadderBoard() {
        return ladderBoard.export();
    }

    public PlayerNamesDto exportPlayerNames() {
        return players.exportNames();
    }

}

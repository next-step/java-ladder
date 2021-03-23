package ladder.domain;

import ladder.dto.LadderGameRequest;
import ladder.dto.LadderGameResult;
import ladder.dto.LadderResultDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final LadderBoard ladderBoard;

    private final PlayerList participatingPlayerList;

    private static final String ALL_PLAYERS = "all";

    public LadderGame(LadderGameRequest ladderGameRequest) {
        this.participatingPlayerList = PlayerList.of(ladderGameRequest.nameList());
        this.ladderBoard = LadderBoard.of(ladderGameRequest);
    }

    public LadderResultDto ladderBoard() {
        return new LadderResultDto(participatingPlayerList, ladderBoard);
    }

    public List<LadderGameResult> play(String playerName) {
        if (ALL_PLAYERS.equalsIgnoreCase(playerName)) {
            return participatingPlayerList.playerList()
                    .stream().map(this::play)
                    .collect(Collectors.toList());
        }
        Player player = participatingPlayerList.player(playerName);
        return Collections.singletonList(play(player));
    }

    private LadderGameResult play(Player player) {
        Prize prize = ladderBoard.prize(player);
        return new LadderGameResult(player, prize);
    }
}

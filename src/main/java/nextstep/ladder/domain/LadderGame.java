package nextstep.ladder.domain;

import nextstep.ladder.domain.player.Player;
import nextstep.ladder.dto.LadderDto;
import nextstep.ladder.dto.PlayerDto;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final List<Player> players;
    private final Ladder ladder;

    public LadderGame(List<String> playerNames, int ladderHeight) {
        this.players = playerNames.stream()
                                  .map(Player::new)
                                  .collect(Collectors.toList());

        ladder = Ladder.of(ladderHeight, players.size());
    }

    public List<PlayerDto> getPlayers() {
        return players.stream().map(Player::export).collect(Collectors.toList());
    }

    public LadderDto getLadder() {
        return ladder.export();
    }

}

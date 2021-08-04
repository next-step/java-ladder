package nextstep.ladder.ladder;

import nextstep.ladder.player.Player;
import nextstep.ladder.player.Players;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public void play() {
        players.getPlayers().forEach(ladder::move);
    }

    public String findPlayerPrize(Prizes prizes, String playerName) {
        Player player = players.findByName(playerName);
        return prizes.findPrize(player.getPosition());
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }
}

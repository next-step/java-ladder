package nextstep.ladder.ladder;

import nextstep.ladder.exception.NotMatchedSizeException;
import nextstep.ladder.player.Player;
import nextstep.ladder.player.Players;

public class LadderPrizes {

    private final Players players;
    private final Prizes prizes;

    private LadderPrizes(Players players, Prizes prizes) {
        validate(players, prizes);
        this.players = players;
        this.prizes = prizes;
    }

    public static LadderPrizes of(String playerNames, String prizeNames) {
        return new LadderPrizes(Players.of(playerNames), Prizes.of(prizeNames));
    }

    private void validate(Players players, Prizes prizes) {
        if (players.count() != prizes.count()) {
            throw new NotMatchedSizeException();
        }
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }

    public String findPlayerPrize(String playerName) {
        Player player = players.findByName(playerName);
        return prizes.findPrize(player.getPosition());
    }
}

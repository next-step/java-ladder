package ladder.domain;

import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import ladder.exception.ErrorMessage;

import java.util.List;
import java.util.Objects;

public class PlayersAndPrizes {

    private final Players players;
    private final Prizes prizes;

    private PlayersAndPrizes(final Players players, final Prizes prizes) {
        validate(players, prizes);

        this.players = players;
        this.prizes = prizes;
    }

    public static PlayersAndPrizes valueOf(final Players players, final Prizes prizes) {
        return new PlayersAndPrizes(players, prizes);
    }

    private static void validate(final Players players, final Prizes prizes) {
        if (Objects.isNull(players) || Objects.isNull(prizes)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
        if (players.count() != prizes.count()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCHED_VALUE);
        }
    }

    public int getPlayersCount() {
        return players.count();
    }

    public int getPrizesCount() {
        return prizes.count();
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }

    public List<String> getPrizeNames() {
        return prizes.getNames();
    }
}

package ladder.domain;

import ladder.domain.ladder.Position;
import ladder.domain.ladder.Positions;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.exception.ErrorMessage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

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
            throw new IllegalArgumentException(ErrorMessage.NOT_SAME_MATCHED_VALUE);
        }
    }

    public Map<Player, Prize> matchPlayerAndPrize(final Positions prizePositions) {
        Map<Player, Prize> matchResult = new LinkedHashMap<>();

        IntStream.range(0, getPlayersCount())
                .mapToObj(Position::of)
                .forEach(playerPosition -> {
                    Player player = players.indexOf(playerPosition);
                    Prize prize = prizes.indexOf(prizePositions.indexOf(playerPosition));

                    matchResult.put(player, prize);
                });

        return matchResult;
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

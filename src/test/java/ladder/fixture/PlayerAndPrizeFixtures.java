package ladder.fixture;

import ladder.domain.PlayersAndPrizes;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayerAndPrizeFixtures {

    public static final List<String> playerNames = Arrays.asList("pobi", "honux", "crong", "jk", "hee");
    public static final List<String> prizeNames = Arrays.asList("꽝", "5000", "꽝", "3000", "1000");
    private final Players singlePlayers;
    private final Prizes singlePrizes;
    private PlayersAndPrizes multiplePlayersAndPrizes;

    private static final List<String> singlePlayerName = Collections.singletonList("heee");
    private static final List<String> singlePrizeName = Collections.singletonList("win");
    private final Players players;
    private final Prizes prizes;
    private PlayersAndPrizes singlePlayersAndPrizes;

    private PlayerAndPrizeFixtures() {
        players = Players.of(playerNames);
        prizes = Prizes.of(prizeNames);

        multiplePlayersAndPrizes = PlayersAndPrizes.valueOf(players, prizes);

        List<String> singlePlayerName = Collections.singletonList("heee");
        List<String> singlePrizeName = Collections.singletonList("win");
        singlePlayers = Players.of(singlePlayerName);
        singlePrizes = Prizes.of(singlePrizeName);

        singlePlayersAndPrizes = PlayersAndPrizes.valueOf(singlePlayers, singlePrizes);
    }

    public static PlayerAndPrizeFixtures of() {
        return new PlayerAndPrizeFixtures();
    }

    public PlayersAndPrizes getMultiplePlayersAndPrizes() {
        return multiplePlayersAndPrizes;
    }

    public PlayersAndPrizes getSinglePlayersAndPrizes() {
        return singlePlayersAndPrizes;
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}

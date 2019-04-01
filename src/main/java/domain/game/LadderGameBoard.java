package domain.game;

import domain.player.Players;
import domain.prize.Prizes;

import java.util.stream.IntStream;

public class LadderGameBoard {

    public static final String ALL_PLAYER_NAME = "all";

    private final Players players;

    private final LaddersAndPrizes laddersAndPrizes;

    public LadderGameBoard(Players players, LaddersAndPrizes laddersAndPrizes) {
        this.players = players;
        this.laddersAndPrizes = laddersAndPrizes;

        if (players.size() != laddersAndPrizes.size()) {
            throw new IllegalArgumentException();
        }
    }

    public Prizes raffle(String playerNames) {
        if (playerNames.equals(ALL_PLAYER_NAME)) {
            return raffle(IntStream.range(0, laddersAndPrizes.size()).toArray());
        }

        return raffle(players.findIndexByName(playerNames));
    }

    private Prizes raffle(int... playerIndexes) {
        return laddersAndPrizes.raffle(playerIndexes);
    }
}

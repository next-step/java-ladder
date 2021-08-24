package ladder.domain.ladder.ladder;

import ladder.domain.player.PlayerNames;
import ladder.domain.prize.LadderPrizes;
import ladder.exception.InvalidPlayerPrizeNumberException;

public class LadderDecorator {

    private final PlayerNames playerNames;
    private final LadderPrizes ladderPrizes;

    private LadderDecorator(PlayerNames playerNames, LadderPrizes ladderPrizes) {
        validate(playerNames, ladderPrizes);
        this.playerNames = playerNames;
        this.ladderPrizes = ladderPrizes;
    }

    public static LadderDecorator of(PlayerNames playerNames, LadderPrizes ladderPrizes) {
        return new LadderDecorator(playerNames, ladderPrizes);
    }

    public int maxLength() {
        return Math.max(playerNames.maxLength(), ladderPrizes.maxLength());
    }

    public PlayerNames getPlayerNames() {
        return playerNames;
    }

    public LadderPrizes getLadderPrizes() {
        return ladderPrizes;
    }

    private void validate(PlayerNames playerNames, LadderPrizes prizes) {
        if (playerNames.size() != prizes.size()) {
            throw new InvalidPlayerPrizeNumberException();
        }
    }
}

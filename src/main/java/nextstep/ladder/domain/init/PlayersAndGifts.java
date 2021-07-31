package nextstep.ladder.domain.init;

import nextstep.ladder.domain.ladder.LadderPosition;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.gift.Gifts;
import nextstep.ladder.exception.NullArgumentException;

import java.util.List;
import java.util.Objects;

public class PlayersAndGifts {
    private final Players players;
    private final Gifts gifts;

    private PlayersAndGifts(Players players, Gifts gifts) {
        validate(players, gifts);
        this.players = players;
        this.gifts = gifts;
    }

    private void validate(Players players, Gifts gifts) {
        if (Objects.isNull(players)) {
            throw new NullArgumentException(Players.class);
        }

        if (Objects.isNull(gifts)) {
            throw new NullArgumentException(Gifts.class);
        }
    }

    public static PlayersAndGifts of(Players players, Gifts gifts) {
        return new PlayersAndGifts(players, gifts);
    }

    public static PlayersAndGifts of(List<String> playersNames, List<String> giftVlues) {
        Players players = Players.init(playersNames);
        Gifts gifts = Gifts.init(giftVlues);

        return new PlayersAndGifts(players, gifts);
    }

    public int numberOfPlayers() {
        return players.numberOfPlayers();
    }

    public Players getPlayers() {
        return players;
    }

    public Gifts getGifts() {
        return gifts;
    }

    public String getPlayerNameAt(LadderPosition startPosition) {
        return players.getNameAt(startPosition);
    }

    public String getGiftAt(LadderPosition endPosition) {
        return gifts.getGiftAt(endPosition);
    }
}

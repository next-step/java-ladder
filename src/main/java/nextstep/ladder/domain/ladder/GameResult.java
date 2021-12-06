package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.gift.Gift;

import java.util.Map;
import java.util.Objects;

import static nextstep.ladder.utils.Validation.checkNotNull;

public class GameResult {

    private final Map<Participant, Gift> winningGifts;

    public GameResult(Map<Participant, Gift> winningGifts) {
        checkNotNull(winningGifts);
        this.winningGifts = winningGifts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(winningGifts, that.winningGifts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningGifts);
    }
}

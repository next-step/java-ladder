package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.gift.Gift;

import java.util.Map;
import java.util.Objects;

import static java.util.Collections.unmodifiableMap;
import static nextstep.ladder.utils.Validation.checkNotNull;

public class GameResult {

    private final Map<Participant, Gift> results;

    public GameResult(Map<Participant, Gift> results) {
        checkNotNull(results);
        this.results = results;
    }

    public Gift winningGift(Participant participant) {
        checkRegistered(participant);
        return results.get(participant);
    }

    private void checkRegistered(Participant participant) {
        if (!results.containsKey(participant)) {
            throw new UnRegisteredParticipantException();
        }
    }

    public Map<Participant, Gift> results() {
        return unmodifiableMap(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}

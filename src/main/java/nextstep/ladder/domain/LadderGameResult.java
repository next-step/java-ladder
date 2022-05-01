package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class LadderGameResult {

    private final Map<Participant, Prize> result;

    public LadderGameResult() {
        this.result = new HashMap<>();
    }

    public void put(Participant participant, Prize prize) {
        result.put(participant, prize);
    }

    public int findPrizeByName(String name) {
        return Optional.ofNullable(result.get(new Participant(name)))
                .map(Prize::getPrize)
                .orElseThrow(() -> new NoSuchElementException("can't find participant with name of " + name));
    }

    public Map<Participant, Prize> getResult() {
        return new HashMap<>(result);
    }
}

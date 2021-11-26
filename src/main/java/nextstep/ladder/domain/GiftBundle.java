package nextstep.ladder.domain;

import java.util.List;

import static nextstep.ladder.utils.Validator.checkNotNull;

public class GiftBundle {

    private final List<Gift> gifts;

    public GiftBundle(List<Gift> gifts) {
        checkNotNull(gifts);
        this.gifts = gifts;
    }

    public Gift gift(Position position) {
        position.checkLessThan(gifts.size());
        return gifts.get(position.getValue());
    }
}

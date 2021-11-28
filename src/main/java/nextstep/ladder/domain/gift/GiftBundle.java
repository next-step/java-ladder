package nextstep.ladder.domain.gift;

import nextstep.ladder.domain.position.Position;

import java.util.List;

import static java.util.Collections.unmodifiableList;
import static nextstep.ladder.utils.Validator.checkNotNull;

public class GiftBundle {

    private final List<Gift> gifts;

    public GiftBundle(List<Gift> gifts) {
        checkNotNull(gifts);
        this.gifts = gifts;
    }

    public boolean isSizeEquals(int size) {
        return (gifts.size() != size);
    }

    public Gift gift(Position position) {
        position.checkLessThan(gifts.size());
        return gifts.get(position.getValue());
    }

    public List<Gift> gifts() {
        return unmodifiableList(gifts);
    }

}

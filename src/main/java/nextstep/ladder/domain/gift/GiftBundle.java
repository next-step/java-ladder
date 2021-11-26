package nextstep.ladder.domain.gift;

import nextstep.ladder.domain.position.Position;

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

    public void checkSizeEquals(int size) {
        if (gifts.size() != size) {
            throw new IllegalArgumentException("개수가 맞지 않습니다.");
        }
    }

}

package nextstep.ladder.domain.gift;

import nextstep.ladder.domain.exception.OutOfRangeIndexException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;
import static nextstep.ladder.utils.Validation.checkNotEmpty;
import static nextstep.ladder.utils.Validation.checkNotNull;

public class GiftBundle {

    private static final int MIN_INDEX = 0;

    private final List<Gift> gifts;

    public GiftBundle(List<Gift> gifts) {
        checkNotEmpty(gifts);
        this.gifts = gifts;
    }

    public static GiftBundle from(List<String> gifts) {
        checkNotNull(gifts);
        return new GiftBundle(createGifts(gifts));
    }

    private static List<Gift> createGifts(List<String> gifts) {
        return gifts.stream()
                .map(Gift::new)
                .collect(Collectors.toList());
    }

    public List<Gift> gifts() {
        return unmodifiableList(gifts);
    }

    public Gift gift(int position) {
        checkPositionRange(position);
        return gifts.get(position);
    }

    private void checkPositionRange(int position) {
        if (position < MIN_INDEX || position >= gifts.size()) {
            throw new OutOfRangeIndexException();
        }
    }

    public boolean hasSize(int size) {
        return gifts.size() == size;
    }
}

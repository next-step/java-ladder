package nextstep.ladder.domain.gift;

import nextstep.ladder.domain.ladder.LadderPosition;
import nextstep.ladder.exception.NullArgumentException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Gifts {
    private final List<Gift> gifts;

    private Gifts(List<String> gifts) {
        validate(gifts);

        this.gifts = gifts.stream()
                .map(Gift::from)
                .collect(Collectors.toList());
    }

    private void validate(List<String> gifts) {
        if (Objects.isNull(gifts)) {
            throw new NullArgumentException("Gifts");
        }
    }

    public static Gifts init(List<String> gifts) {
        return new Gifts(gifts);
    }

    public List<String> getGifts() {
        return gifts.stream()
                .map(Gift::getGift)
                .collect(Collectors.toList());
    }

    public String getGiftAt(LadderPosition endPosition) {
        return gifts.get(endPosition.toInt())
                .getGift();
    }
}

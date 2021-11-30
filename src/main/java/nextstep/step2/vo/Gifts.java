package nextstep.step2.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Gifts {

    private static final int MIN_GIFT_COUNT = 2;
    private static final String NULL_OR_LESS_SIZE_MESSAGE = "최소 " + MIN_GIFT_COUNT + "명 이상의 당첨 선물이 필요합니다.";

    private final List<Gift> gifts;

    private Gifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public static Gifts of(List<Gift> gifts) {

        if (gifts == null || gifts.size() < MIN_GIFT_COUNT) {
            throw new IllegalArgumentException(NULL_OR_LESS_SIZE_MESSAGE);
        }

        return new Gifts(gifts);
    }

    public static Gifts of(String input) {

        if (input == null) {
            throw new IllegalArgumentException(NULL_OR_LESS_SIZE_MESSAGE);
        }

        return Arrays.stream(input.split(","))
                .map(Gift::of)
                .collect(collectingAndThen(toList(), Gifts::new));
    }

    public int size() {
        return gifts.size();
    }

    public boolean equalsSize(int size) {
        return size() == size;
    }

    public List<Gift> getGifts() {
        return gifts.stream()
                .map(gift -> Gift.of(gift.getValue()))
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Gifts names1 = (Gifts) o;
        return Objects.equals(gifts, names1.gifts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gifts);
    }
}

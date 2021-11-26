package nextstep.ladder.domain.gift;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static nextstep.ladder.utils.Validator.checkNotNull;

public class Gift {

    private static final int MIN_GIFT_LENGTH = 1;
    public static final String EMPTY_NAME_ERROR_MESSAGE = format("상품명의 길이는 %d 이상이어야 합니다", MIN_GIFT_LENGTH);

    private final String name;

    public Gift(String name) {
        checkNotEmpty(name);
        this.name = name;
    }

    public static List<Gift> listOf(List<String> gifts) {
        checkNotNull(gifts);
        return createGifts(gifts);
    }

    private static List<Gift> createGifts(List<String> gifts) {
        return gifts.stream()
                .map(Gift::new)
                .collect(Collectors.toList());
    }

    private void checkNotEmpty(String name) {
        if (name == null || name.length() < MIN_GIFT_LENGTH) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift1 = (Gift) o;
        return Objects.equals(name, gift1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Gift{" +
                "name='" + name + '\'' +
                '}';
    }

}

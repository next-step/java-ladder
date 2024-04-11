package ladder.domain.item;

import java.util.List;
import java.util.stream.Collectors;

public class Items {

    private final List<Item> items;

    private Items(final List<Item> items) {
        validateItemsAreNotEmpty(items);

        this.items = items;
    }

    private void validateItemsAreNotEmpty(final List<Item> items) {
        if (items.isEmpty()) {
            throw new IllegalArgumentException("사다리 결과가 존재하지 않습니다.");
        }
    }

    public List<String> names() {
        return this.items.stream()
                .map(Item::name)
                .collect(Collectors.toUnmodifiableList());
    }

    public int count() {
        return this.items.size();
    }

    public Item get(final int position) {
        validatePositionIsInRange(position);

        return this.items.get(position);
    }

    private void validatePositionIsInRange(final int position) {
        if (position < 0 || position >= count()) {
            throw new IllegalArgumentException("포지션에 해당하는 사다리 결과가 존재하지 않습니다. 포지션: " + position);
        }
    }

    public static Items from(final List<String> itemNames) {
        final List<Item> items = itemNames.stream()
                .map(Item::new)
                .collect(Collectors.toUnmodifiableList());

        return new Items(items);
    }
}

package ladder.domain.play;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Items {
    public static final int MIN_ITEM_SIZE = 2;

    private List<Item> items = new ArrayList<>();

    public Items(List<String> items) {
        validate(items);
        items.forEach(item -> this.items.add(Item.of(item.trim())));
    }

    private void validate(List<String> items) {
        if (items == null || items.size() < MIN_ITEM_SIZE) {
            throw new IllegalArgumentException("입력 값은 " + MIN_ITEM_SIZE + "개 이상이어야 합니다.");
        }
    }

    public static Items of(List<String> items) {
        return new Items(items);
    }

    public int getCountOfItems() {
        return items.size();
    }

    @Override
    public String toString() {
        return this.items.stream()
                .map(Item::toString)
                .collect(Collectors.joining());
    }
}

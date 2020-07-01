package ladder.domain.play;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Items {
    public static final int MIN_ITEM_SIZE = 2;

    List<Item> items = new ArrayList<>();

    public Items(List<? extends Item> items) {
        this.items.addAll(items);
    }

    public static Items of(List<String> targets) {
        validate(targets);
        List<Item> items = targets.stream()
                .map(Item::of)
                .collect(Collectors.toList());

        return new Items(items);
    }

    private static void validate(List<String> items) {
        if (items == null || items.size() < MIN_ITEM_SIZE) {
            throw new IllegalArgumentException("입력 값은 " + MIN_ITEM_SIZE + "개 이상이어야 합니다.");
        }
    }

    public int getCountOf() {
        return items.size();
    }

    public boolean sameSize(Items items) {
        return this.getCountOf() == items.getCountOf();
    }

    public Item get(int index) {
        return items.get(index);
    }

    public int findIndexBy(String name) {
        validateContains(name);

        return IntStream.range(0, items.size())
                .filter(i -> items.get(i).same(name))
                .findFirst()
                .getAsInt();
    }

    void validateContains(String name) {
        if (!items.contains(Item.of(name))) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return this.items.stream()
                .map(Item::toString)
                .collect(Collectors.joining());
    }
}

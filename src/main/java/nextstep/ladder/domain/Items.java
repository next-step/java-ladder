package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Items {
    private static final String SEPARATORS = ",";

    private final List<Item> items;

    private Items(List<Item> items) {
        this.items = items;
    }

    public static Items from(String itemTexts) {
        List<Item> items = Arrays.stream(itemTexts.split(SEPARATORS))
                .map(Item::new)
                .collect(Collectors.toList());
        return new Items(items);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}

package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import nextstep.ladder.exception.CategorySizeException;

public class Category {

    private final List<Item> category;

    public Category(List<Item> category, Players players) {
        validSize(category, players);
        this.category = category;
    }

    public Item get(int index) {
        return category.get(index);
    }

    public List<Item> getCategory() {
        return Collections.unmodifiableList(category);
    }

    private void validSize(List<Item> category, Players players) {
        if (!players.isSize(category.size())) {
            throw new CategorySizeException();
        }
    }

}

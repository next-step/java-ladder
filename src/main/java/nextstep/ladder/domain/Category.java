package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.exception.CategorySizeException;

public class Category {

    private final List<Name> category;

    private Category(List<Name> category, Players players) {
        validSize(category, players);
        this.category = category;
    }

    public static Category of(InputString inputCategory, Players players) {
        List<Name> category = Arrays.stream(inputCategory.split())
            .map(Name::of)
            .collect(Collectors.toCollection(ArrayList::new));
        return new Category(category, players);
    }

    public Name get(int index) {
        return category.get(index);
    }

    public List<Name> getCategory() {
        return Collections.unmodifiableList(category);
    }

    private void validSize(List<Name> category, Players players) {
        if (!players.isSize(category.size())) {
            throw new CategorySizeException();
        }
    }

}

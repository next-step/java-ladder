package nextstep.ladder.step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.step3.exception.CategorySizeException;

public class Category {

    private final List<Name> category;

    private Category(List<Name> category) {
        this.category = category;
    }

    public static Category of(InputString inputCategory, Players players) {
        List<Name> category = Arrays.stream(inputCategory.split())
            .map(Name::of)
            .collect(Collectors.toCollection(ArrayList::new));

        validSize(category, players);
        return new Category(category);
    }

    public Name get(int index) {
        return category.get(index);
    }

    public List<Name> getCategory() {
        return Collections.unmodifiableList(category);
    }

    private static void validSize(List<Name> category, Players players) {
        if (!players.isSize(category.size())) {
            throw new CategorySizeException();
        }
    }

}

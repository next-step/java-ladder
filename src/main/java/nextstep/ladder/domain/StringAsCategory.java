package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringAsCategory extends AbstractInput {

    public StringAsCategory(String input) {
        super(input);
    }

    public Category category(Players players) {
        List<Item> category = getStream()
            .map(StringFactory::item)
            .collect(Collectors.toCollection(ArrayList::new));
        return new Category(category, players);
    }

}

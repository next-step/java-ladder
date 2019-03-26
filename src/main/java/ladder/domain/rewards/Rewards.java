package ladder.domain.rewards;

import ladder.common.Constants;
import ladder.domain.players.Players;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private List<Item> items;

    private Rewards(List<Item> people) {
        this.items = people;
    }

    public static Rewards generate(String names, Players players) {
        String[] splitedNames = names.split(Constants.COMMA);
        if (!isMatchPeopleCount(splitedNames.length, players.size())) {
            throw new IllegalArgumentException();
        }
        return new Rewards(Arrays.stream(splitedNames)
            .map(String::trim)
            .map(Item::new)
            .collect(Collectors.toList()));
    }

    private static Boolean isMatchPeopleCount(int itemsCount, int peopleCount) {
        return itemsCount == peopleCount;
    }

    public int size() {
        return this.items.size();
    }

    public List<Item> getPeople() {
        return Collections.unmodifiableList(items);
    }
}

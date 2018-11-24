package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Gifts {

    private static final String SPLITTER = ",";
    private List<Gift> gifts;

    private Gifts(String[] names) {
        gifts = Arrays.asList(names).stream()
                .map(Gift::create)
                .collect(Collectors.toList());
    }

    public static Gifts create(String names) {
        return new Gifts(names.split(SPLITTER));
    }

    public Gift get(int index) {
        return gifts.get(index);
    }

    public int size() {
        return gifts.size();
    }

    @Override
    public String toString() {
        return gifts.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}

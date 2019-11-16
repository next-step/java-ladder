package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Gifts {
    private static final String GIFT_STRING_SEPARATOR = ",";

    private List<Gift> gifts;

    public Gifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public static Gifts of(String string) {
        String[] names = string.split(GIFT_STRING_SEPARATOR);
        List<Gift> gifts = new ArrayList<>();

        for (String name : names) {
            gifts.add(new Gift(name.trim()));
        }

        return new Gifts(gifts);
    }

    public int size() {
        return gifts.size();
    }

    public Gift giftByIndex(int index) {
        return gifts.get(index);
    }
}

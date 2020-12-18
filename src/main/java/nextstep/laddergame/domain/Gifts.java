package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Gifts {
    private final List<Gift> gifts;

    public Gifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public static Gifts of(int countOfPeople, String giftNames) {
        String[] splitGiftNames = splitGiftName(giftNames);
        if (isNotSameCount(countOfPeople, splitGiftNames)) {
            throw new IllegalArgumentException("결과는 사용자 수와 일치해야 합니다.");
        }

        List<Gift> gifts = new ArrayList<>();
        for (String giftName : splitGiftNames) {
            gifts.add(Gift.from(giftName));
        }

        return new Gifts(gifts);
    }

    private static boolean isNotSameCount(int countOfPeople, String[] splitGiftNames) {
        return countOfPeople != splitGiftNames.length;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    private static String[] splitGiftName(String giftNames) {
        return giftNames.split(",");
    }
}

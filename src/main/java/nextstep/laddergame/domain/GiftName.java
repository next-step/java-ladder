package nextstep.laddergame.domain;

import java.util.Objects;

public class GiftName {

    private final String giftName;

    public GiftName(String giftName) {
        this.giftName = giftName;
    }

    public static GiftName from(String giftName) {
        if (isBlank(giftName)) {
            throw new IllegalArgumentException("선물 이름은 공백이 될 수 없습니다.");
        }

        return new GiftName(giftName);
    }

    private static boolean isBlank(String giftName) {
        return Objects.isNull(giftName) || giftName.trim().isEmpty();
    }

    public String getGiftName() {
        return giftName;
    }
}

package nextstep.laddergame.domain;

public class Gift {
    private final GiftName giftName;

    public Gift(String giftName) {
        this.giftName = GiftName.from(giftName);
    }

    public static Gift from(String giftName) {
        return new Gift(giftName);
    }

    public String getName() {
        return this.giftName.getGiftName();
    }
}

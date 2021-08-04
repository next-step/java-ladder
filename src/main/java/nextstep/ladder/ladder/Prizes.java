package nextstep.ladder.ladder;

import nextstep.ladder.util.StringUtil;

public class Prizes {

    private final String[] prizeNames;

    private Prizes(String[] prizeNames) {
        this.prizeNames = prizeNames;
    }

    public static Prizes of(String prizes) {
        return new Prizes(StringUtil.split(prizes));
    }

    public String findPrize(int index) {
        indexValidate(index);
        return prizeNames[index];
    }

    public String[] getPrizeNames() {
        return prizeNames;
    }

    public int count() {
        return prizeNames.length;
    }

    private void indexValidate(int index) {
        int length = prizeNames.length - 1;
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("상품 정보는 0부터 " + length + "까지 조회 가능합니다.");
        }
    }
}

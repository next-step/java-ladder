package nextstep.ladder.ladder;

import nextstep.ladder.util.StringUtil;

public class LadderPrize {

    private final String[] prizes;

    private LadderPrize(String[] prizes) {
        this.prizes = prizes;
    }

    public static LadderPrize of(String prizes) {
        return new LadderPrize(StringUtil.split(prizes));
    }

    public String findPrize(int index) {
        indexValidate(index);
        return prizes[index];
    }

    public String[] getPrizes() {
        return prizes;
    }

    private void indexValidate(int index) {
        int length = prizes.length - 1;
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("상품 정보는 0부터 " + length + "까지 조회 가능합니다.");
        }
    }
}

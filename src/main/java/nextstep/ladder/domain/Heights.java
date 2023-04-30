package nextstep.ladder.domain;

public class Heights {

    private final static int MINIMUM_VALUE = 1;

    private final int heights;

    public Heights(int heights) {
        isOverMinimumValue(heights);
        this.heights = heights;
    }

    private void isOverMinimumValue(int heights) {
        if (heights < MINIMUM_VALUE) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요.");
        }
    }

}
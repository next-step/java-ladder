package nextstep.ladder.domain;

public class Heights {

    private final static int MINIMUM_VALUE = 1;

    private int heights;

    private Heights(int heights) {
        checkValueValidation(heights);
        this.heights = heights;
    }

    public static Heights from(int heights) {
        return new Heights(heights);
    }

    private void checkValueValidation(int heights) {
        if (heights < MINIMUM_VALUE) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요.");
        }
    }

    public void countDown() {
        heights -= MINIMUM_VALUE;
    }

    public boolean isOverMinimum() {
        return heights >= MINIMUM_VALUE;
    }
}
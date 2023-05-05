package nextstep.ladder.domain;

public class Heights {
    private final int heights;

    public Heights(int heights) {
        checkPositiveNumber(heights);
        this.heights = heights;
    }

    private void checkPositiveNumber(int heights) {
        if (heights <= 0) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요");
        }
    }

    public int getHeights() {
        return heights;
    }
}

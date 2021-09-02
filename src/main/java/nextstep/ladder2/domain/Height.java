package nextstep.ladder2.domain;

public class Height {
    private int height;

    public Height(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("0 이상의 사다리 높이 값을 입력해주세요.");
        }

        this.height = height;
    }

    public int getValue() {
        return this.height;
    }
}

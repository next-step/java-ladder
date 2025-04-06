package nextstep.ladder.domain;

public class Height {

    private final int height;

    public Height(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("높이는 음수가 될 수 없습니다.");
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

}

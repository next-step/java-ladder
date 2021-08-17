package nextstep.ladder.model;

public class Height {
    private int value;

    public Height(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("높이는 음수가 될 수 없습니다!");
        }

        this.value = value;
    }
}

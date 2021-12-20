package ladder.domain.ladder;

public class Height {

    private final int height;

    public Height(int height) {
        if (height > 10 || height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1이상 10이하로 설정 해주세요.");
        }
        this.height = height;
    }
}

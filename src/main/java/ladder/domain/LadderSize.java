package ladder.domain;

public class LadderSize {
    private final long width;
    private final long height;

    private LadderSize(long width, long height) {
        this.width = width;
        this.height = height;
    }

    public static LadderSize of(Players players, long height) {
        return new LadderSize(players.size(), height); // 사다리 생성시 라인의 이동 경로 수는 참가자 - 1 값이다.
    }

    public long width() {
        return width;
    }

    public long height() {
        return height;
    }
}

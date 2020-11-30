package nextstep.ladder.entity.ladder;

public class LadderHeight {

    private final int height;

    public LadderHeight(int height) {
        throwIfFloorsLessThanOne(height);
        this.height = height;
    }

    private void throwIfFloorsLessThanOne(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상으로 입력해주세요.");
        }
    }

    public int getHeight() {
        return height;
    }

}

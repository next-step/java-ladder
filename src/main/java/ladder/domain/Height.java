package ladder.domain;

public class Height {
    private final static int MINIMUN_HEIGHT = 0;

    private int height;

    public Height(int inputHeight) {

        if (inputHeight < MINIMUN_HEIGHT) {
            throw new IllegalArgumentException("0보다 작을 수 없습니다.");
        }

        this.height = inputHeight;
    }

    public int getHeight() {
        return height;
    }
}

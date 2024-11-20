package nextstep.ladder.generator;

public class GeneratorWidthSize {
    private int size;

    public GeneratorWidthSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("사이즈는 0미만일 수 없습니다.");
        }
        this.size = size;
    }

    public int value() {
        return size;
    }

    public boolean greater(int i) {
        return i < size;
    }
}

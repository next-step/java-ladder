package nextstep.ladder.domain.line;

public class VerticalLines {

    private final int length;
    private final VerticalLine left;
    private final VerticalLine right;

    public VerticalLines(int length) {
        this.length = length;
        this.left = new VerticalLine(length);
        this.right = new VerticalLine(length);
    }

    @Override
    public String toString() {
        return "VerticalLines{" +
                "length=" + length +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

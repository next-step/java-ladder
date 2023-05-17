package nextstep.ladder.domain;

public class TestLinesGenerator implements LinesGenerator {

    private static final int WIDTH_OUT_OF_RANGE_BLOCK_NUMBER = 2;
    private static final int WIDTH_NEXT_NUMBER = 1;

    @Override
    public Lines generate(final int width, final int height) {
        Lines lines = new Lines();
        lines.addLine(makeLine(width - WIDTH_OUT_OF_RANGE_BLOCK_NUMBER, height));
        return lines;
    }

    private Line makeLine(final int x, final int y) {
        return new Line(new Position(x, y), new Position(x + WIDTH_NEXT_NUMBER, y));
    }

}

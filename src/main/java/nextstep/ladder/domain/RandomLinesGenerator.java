package nextstep.ladder.domain;

import java.util.Random;

public class RandomLinesGenerator implements LinesGenerator {

    private static final int WIDTH_OUT_OF_RANGE_BLOCK_NUMBER = 1;
    private static final int WIDTH_NEXT_NUMBER = 1;

    private static final Random RANDOM = new Random();

    @Override
    public Lines generate(final int width, final int height) {
        Lines lines = new Lines();
        for (int i = RANDOM.nextInt(width - WIDTH_OUT_OF_RANGE_BLOCK_NUMBER); i < width - WIDTH_OUT_OF_RANGE_BLOCK_NUMBER; i++) {
            lines.addLine(getLine(i, height));
        }
        return lines;
    }

    private Line getLine(final int x, final int y) {
        return new Line(new Position(x, y), new Position(x + WIDTH_NEXT_NUMBER, y));
    }

}

package nextstep.ladder.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class Ladders implements Iterable<Ladder> {
    private final Ladder[] ladders;

    public Ladders(int width, int height) {
        this.ladders = IntStream.range(0, width - 1).mapToObj(i -> new Ladder(height)).toArray(Ladder[]::new);
    }

    public void drawSteps(DrawStrategy drawStrategy) {
        for (int i = 0; i < ladders.length; i++) {
            ladders[i].drawSteps(drawStrategy, i == 0 ? null : ladders[i - 1]);
        }
    }

    public int height() {
        return ladders[0].height();
    }

    @Override
    public Iterator<Ladder> iterator() {
        return Arrays.stream(ladders).iterator();
    }
}

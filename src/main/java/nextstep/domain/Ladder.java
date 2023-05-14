package nextstep.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ladder implements Iterable<Line>{
    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder makeLadder(int height, int countOfPerson) {
        List<Line> ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladder.add(new Line(countOfPerson, new Random()::nextBoolean));
        }

        return new Ladder(ladder);
    }

    public List<Line> ladder() {
        return ladder;
    }

    @Override
    public Iterator<Line> iterator() {
        return ladder.iterator();
    }
}

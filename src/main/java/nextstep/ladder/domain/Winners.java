package nextstep.ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Winners implements Iterable<Winner> {
    private List<Winner> winners;

    public Winners(List<Winner> winners) {
        this.winners = winners;
    }

    public static Winners create(List<Winner> winners) {
        return new Winners(winners);
    }

    @Override
    public Iterator<Winner> iterator() {
        return winners.iterator();
    }
}

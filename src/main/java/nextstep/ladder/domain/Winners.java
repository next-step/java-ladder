package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Winners {
    private List<Winner> winners;

    public Winners(List<Winner> winners) {
        this.winners = winners;
    }

    public static Winners create(List<Winner> winners) {
        return new Winners(winners);
    }

    public Stream<Winner> stream() {
        return winners.stream();
    }
}

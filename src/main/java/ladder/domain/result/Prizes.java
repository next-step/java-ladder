package ladder.domain.result;

import ladder.domain.common.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Prizes {

    private static final int SYNC = 1;
    private final List<Prize> prizes;

    public Prizes(String[] values) {
        this.prizes = Arrays.stream(values)
                .map(Prize::new)
                .collect(toList());
    }

    public Destinations makeDestinations(int height) {
        List<Destination> destinations = new ArrayList<>();
        for (int i = 0; i < prizes.size(); i++) {
            Point point = new Point(i, height + SYNC);
            destinations.add(new Destination(prizes.get(i), point));
        }
        return new Destinations(destinations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prizes prizes1 = (Prizes) o;
        return Objects.equals(prizes, prizes1.prizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizes);
    }
}

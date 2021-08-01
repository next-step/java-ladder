package nextstep.ladder.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Prizes implements Iterable<Prize> {
    public static final String DILIMETER = ",";
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(String names) {
        return Arrays.stream(names.split(DILIMETER))
            .map(Prize::of)
            .collect(collectingAndThen(toList(), Prizes::new));
    }

    public Prize findByIndex(int index) {
        return prizes.get(index);
    }

    @Override
    public Iterator<Prize> iterator() {
        return prizes.iterator();
    }
}

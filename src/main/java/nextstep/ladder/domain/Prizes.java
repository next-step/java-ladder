package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes implements Iterable<Prize> {
    public static final String DILIMETER = ",";
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(String names) {
        return new Prizes(Arrays.stream(names.split(DILIMETER))
            .map(Prize::of)
            .collect(Collectors.toList()));
    }

    public int size() {
        return prizes.size();
    }

    public Prize findByIndex(int index) {
        return prizes.get(index);
    }

    @Override
    public Iterator<Prize> iterator() {
        return prizes.iterator();
    }
}

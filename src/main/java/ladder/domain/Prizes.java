package ladder.domain;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Prizes implements Iterable<Prize> {
    private final List<Prize> prizes;

    public Prizes(String[] prizes) {
        this(
                Arrays.stream(prizes)
                        .map(Prize::new)
                        .collect(Collectors.toList())
        );
    }

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public Prize get(int index) {
        return prizes.get(index);
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

    @Override
    public Iterator<Prize> iterator() {
        return prizes.iterator();
    }

    @Override
    public void forEach(Consumer<? super Prize> action) {
        prizes.forEach(action);
    }

    @Override
    public Spliterator<Prize> spliterator() {
        return prizes.spliterator();
    }
}

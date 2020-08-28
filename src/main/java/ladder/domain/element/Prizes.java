package ladder.domain.element;

import ladder.domain.common.Printable;
import ladder.util.CommaSplitter;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes implements Iterable<Prize>, Printable {

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes fromText(String text) {
        List<Prize> prizes = new ArrayList<>();
        CommaSplitter.split(text)
                .forEach(s -> prizes.add(new Prize(s)));
        return new Prizes(prizes);
    }

    public Prize get(int index) {
        return prizes.get(index);
    }

    public int size() {
        return prizes.size();
    }

    @Nonnull
    @Override
    public Iterator<Prize> iterator() {
        return prizes.iterator();
    }

    @Override
    public String print() {
        return prizes.stream()
                .map(Prize::print)
                .collect(Collectors.joining(" "));
    }
}

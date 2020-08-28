package ladder.domain.element;

import ladder.domain.common.Printable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPrizes implements Iterable<LadderPrize>, Printable {

    private final List<LadderPrize> ladderPrizes = new ArrayList<>();

    public void add(LadderPrize ladderPrize) {
        ladderPrizes.add(ladderPrize);
    }

    @Override
    public String print() {
        return ladderPrizes.stream()
                .map(LadderPrize::print)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Nonnull
    @Override
    public Iterator<LadderPrize> iterator() {
        return ladderPrizes.iterator();
    }
}

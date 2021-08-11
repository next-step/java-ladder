package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import nextstep.ladder.domain.exception.InvalidCreateLineException;

public class HorizontalLine {

    private final List<Boolean> bridges;

    private HorizontalLine(final List<Boolean> bridges) {
        createValidation(bridges);
        this.bridges = bridges;
    }

    private HorizontalLine(final LineBridgeGenerator generator, final int playerCount) {
        final List<Boolean> bridges = new ArrayList<>();
        bridges.add(false);
        for (int i = 1; i < playerCount; i++) {
            bridges.add(generator.generate(bridges.get(i - 1)));
        }
        bridges.add(false);

        createValidation(bridges);
        this.bridges = bridges;
    }

    public static HorizontalLine of(final List<Boolean> bridges) {
        return new HorizontalLine(bridges);
    }

    public static HorizontalLine of(final int playerCount) {
        return new HorizontalLine(new DefaultLineBridgeGenerator(), playerCount);
    }

    private void createValidation(final List<Boolean> bridges) {
        final BiConsumer<Boolean, Boolean> validation = (current, next) -> {
            if (!((current) ? !next : true)) {
                throw new InvalidCreateLineException();
            }
        };

        for (int i = 0; i < bridges.size() - 1; i++) {
            validation.accept(bridges.get(i), bridges.get(i + 1));
        }
    }

    public int next(final int index) {
        if (bridges.get(index)) {
            return index - 1;
        }

        if (bridges.get(index + 1)) {
            return index + 1;
        }

        return index;
    }

    public int size() {
        return bridges.size();
    }

    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}

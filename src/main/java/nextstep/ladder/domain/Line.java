package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import nextstep.ladder.domain.exception.InvalidCreateLineException;

public class Line {

    private final List<Boolean> exists;

    private Line(final List<Boolean> exists) {
        createValidation(exists);
        this.exists = exists;
    }

    private Line(final LineExistsGenerator generator, final int playerCount) {
        final List<Boolean> exists = new ArrayList<>();
        exists.add(false);
        for (int i = 1; i < playerCount; i++) {
            exists.add(generator.generate(exists.get(i - 1)));
        }

        createValidation(exists);
        this.exists = exists;
    }

    private void createValidation(final List<Boolean> exists) {
        final BiConsumer<Boolean, Boolean> validation = (current, next) -> {
            if (!((current) ? !next : true)) {
                throw new InvalidCreateLineException();
            }
        };

        for (int i = 0; i < exists.size() - 1; i++) {
            validation.accept(exists.get(i), exists.get(i + 1));
        }
    }

    public static Line of(final List<Boolean> exists) {
        return new Line(exists);
    }

    public static Line of(final int playerCount) {
        return new Line(new DefaultLineExistsGenerator(), playerCount);
    }

    public int size() {
        return exists.size();
    }

    public List<Boolean> getExists() {
        return Collections.unmodifiableList(exists);
    }
}

package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> exists;

    private Line(final LineExistsGenerator generator, final int playerCount) {
        final List<Boolean> exists = new ArrayList<>();
        exists.add(false);
        for (int i = 1; i < playerCount; i++) {
            exists.add(generator.generate(exists.get(i - 1)));
        }
        this.exists = exists;
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

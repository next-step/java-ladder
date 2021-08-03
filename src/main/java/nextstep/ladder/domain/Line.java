package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final LineExistsGenerator lineExistsGenerator;
    private final List<Boolean> exists;

    private Line(LineExistsGenerator generator, List<Boolean> exists) {
        this.lineExistsGenerator = generator;
        this.exists = exists;
    }

    private Line(LineExistsGenerator generator, int playerCount) {
        this.lineExistsGenerator = generator;

        List<Boolean> exists = new ArrayList<>();
        exists.add(false);
        for (int i = 1; i < playerCount; i++) {
            exists.add(lineExistsGenerator.generate(exists.get(i - 1)));
        }
        this.exists = exists;
    }

    public static Line of(int playerCount) {
        return new Line(new DefaultLineExistsGenerator(), playerCount);
    }

    public int size() {
        return exists.size();
    }

    public boolean lineExists(int index) {
        return exists.get(index);
    }

    public List<Boolean> getExists() {
        return Collections.unmodifiableList(exists);
    }
}

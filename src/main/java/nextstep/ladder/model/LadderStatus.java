package nextstep.ladder.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class LadderStatus implements Iterable<Line> {
    String[] names;
    Lines lines;

    public LadderStatus(String[] names, int height) {
        this.names = names;
        lines = new Lines(names.length, height);
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.getIterator();
    }

    public String getLadderNames() {
        return Arrays.stream(names)
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(" "));
    }
}

package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultLadderReader implements LadderReader {

    private final List<List<LadderItem>> lines;
    private int next = 0;

    public DefaultLadderReader(List<? extends SupportedLadderItems> lines) {
        this.lines = lines.stream().map(line -> line.toLadderItems()).collect(Collectors.toList());
    }

    private boolean isEOL() {
        return next >= lines.size();
    }

    @Override
    public List<LadderItem> readLine() {
        if (isEOL()) return null;
        return lines.get(next++);
    }

}

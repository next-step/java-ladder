package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {
    private final int maxHeight;
    private final List<BaseUserLine> lines;

    public Ladder(int maxHeight, List<BaseUserLine> lines) {
        this.maxHeight = maxHeight;
        this.lines = lines;
    }

    public int size() {
        return lines.size();
    }

    public ConnectPoints getConnectionPoints(final int userNo) {
        return lines.get(userNo).getConnectPoints();
    }

    public List<String> getGameUserName() {
        return lines.stream()
                .map(BaseUserLine::getLadderGameUser)
                .map(Objects::toString)
                .collect(Collectors.toList());
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}

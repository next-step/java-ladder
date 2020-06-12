package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {
    private final int maxHeight;
    private List<LadderVerticalBaseLine> lines = new ArrayList<>();

    public Ladder(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int size() {
        return lines.size();
    }

    public ConnectPoints getConnectionPoints(final int userNo) {
        return lines.get(userNo).getConnectPoints();
    }

    public List<String> getGameUserName() {
        return lines.stream()
                .map(LadderVerticalBaseLine::getLadderGameUser)
                .map(Objects::toString)
                .collect(Collectors.toList());
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void addConnection(LadderVerticalBaseLine ladderVerticalBaseLine) {
        this.lines.add(ladderVerticalBaseLine);
    }

    public boolean canConnect(int currentUserIndex, Point point) {
        return !lines.get(currentUserIndex - 1).connectedWith(point);
    }
}

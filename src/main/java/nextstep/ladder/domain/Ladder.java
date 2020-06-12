package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {
    private final int maxHeight;
    private final List<LadderVerticalBaseLine> lines;


    public Ladder(int maxHeight) {
        this.maxHeight = maxHeight;
        this.lines = new ArrayList<>();
    }

    public Ladder(Ladder ladder) {
        this.maxHeight = ladder.maxHeight;
        this.lines = Collections.unmodifiableList(ladder.lines);
    }

    public void addConnection(LadderVerticalBaseLine ladderVerticalBaseLine) {
        this.lines.add(ladderVerticalBaseLine);
    }

    public boolean canConnect(int currentUserIndex, Point point) {
        return !lines.get(currentUserIndex - 1).connectedWith(point);
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

    public int size() {
        return lines.size();
    }
}

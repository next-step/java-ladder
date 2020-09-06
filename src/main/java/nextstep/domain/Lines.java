package nextstep.domain;

import java.util.Collections;
import java.util.List;

import static nextstep.domain.LadderGameConfig.TRACK_STEP_SIZE;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getLineSize() {
        return lines.size();
    }

    public boolean isPossibleMoveLeftTrack(int lineNumber, int trackNumber) {
        return getPoint(lineNumber, trackNumber - TRACK_STEP_SIZE);
    }

    public boolean isPossibleMoveRightTrack(int lineNumber, int trackNumber) {
        return getPoint(lineNumber, trackNumber);
    }

    private Boolean getPoint(int lineNumber, int trackNumber) {
        return lines.get(lineNumber).getPoint(trackNumber);
    }

}

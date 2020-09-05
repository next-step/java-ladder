package nextstep.domain;

import java.util.Collections;
import java.util.List;

public class LadderGameManager {

    private final List<Line> lines;

    public LadderGameManager(List<Line> lines) {
        this.lines = lines;
    }

    public int start(int trackNumber) {
        for (int i = 0; i < lines.size(); i++) {
            trackNumber = getNextTrackNumber(i, trackNumber);
        }
        return trackNumber;
    }

    public int getNextTrackNumber(int lineNumber, int trackNumber) {
        return lines.get(lineNumber).getNextTrackNumber(trackNumber);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}

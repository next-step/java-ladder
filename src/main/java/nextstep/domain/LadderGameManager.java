package nextstep.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameManager {

    private final List<Track> tracks;
    private final List<Line> lines;

    public LadderGameManager(Participants participants, List<Line> lines) {
        this.tracks = IntStream.range(0, participants.getPersonSize())
                .mapToObj(Track::new)
                .collect(Collectors.toList());
        this.lines = lines;
    }

    public int start(int trackNumber) {
        for (int i = 0; i < lines.size(); i++) {
            trackNumber = getNextTrackNumber(i, trackNumber);
        }
        return trackNumber;
    }

    public int getNextTrackNumber(int lineNumber, int trackNumber) {
        if (isPossibleMoveLeftTrack(lineNumber, trackNumber)) {
            return trackNumber - 1;
        }
        if (isPossibleMoveRightTrack(lineNumber, trackNumber)) {
            return trackNumber + 1;
        }
        return trackNumber;
    }

    private boolean isPossibleMoveLeftTrack(int lineNumber, int trackNumber) {
        if (isFirstTrack(trackNumber)) {
            return false;
        }
        return lines.get(lineNumber).getPoints().get(trackNumber - 1);
    }

    private boolean isPossibleMoveRightTrack(int lineNumber, int trackNumber) {
        if (isLastTrack(trackNumber)) {
            return false;
        }
        return lines.get(lineNumber).getPoints().get(trackNumber);
    }

    public boolean isFirstTrack(int trackNumber) {
        return tracks.indexOf(new Track(trackNumber)) == 0;
    }

    public boolean isLastTrack(int trackNumber) {
        return tracks.indexOf(new Track(trackNumber)) == tracks.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}

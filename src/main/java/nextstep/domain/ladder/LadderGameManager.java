package nextstep.domain.ladder;

import nextstep.domain.track.Tracks;
import nextstep.domain.line.Line;
import nextstep.domain.line.Lines;
import nextstep.domain.person.Participants;

import java.util.Collections;
import java.util.List;

import static nextstep.domain.config.LadderGameConfig.TRACK_STEP_SIZE;

public class LadderGameManager {

    private final Tracks tracks;
    private final Lines lines;

    public LadderGameManager(Participants participants, List<Line> lines) {
        this.tracks = new Tracks(participants.getPersonSize());
        this.lines = new Lines(lines);
    }

    public int start(int trackNumber) {
        for (int i = 0; i < lines.getLineSize(); i++) {
            trackNumber = getNextTrackNumber(i, trackNumber);
        }
        return trackNumber;
    }

    public int getNextTrackNumber(int lineNumber, int trackNumber) {
        if (!tracks.isFirstTrack(trackNumber) && lines.isPossibleMoveLeftTrack(lineNumber, trackNumber)) {
            return trackNumber - TRACK_STEP_SIZE;
        }
        if (!tracks.isLastTrack(trackNumber) && lines.isPossibleMoveRightTrack(lineNumber, trackNumber)) {
            return trackNumber + TRACK_STEP_SIZE;
        }
        return trackNumber;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines.getLines());
    }

}

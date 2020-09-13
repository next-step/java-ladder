package nextstep.domain.ladder;

import nextstep.domain.line.Line;
import nextstep.domain.line.LineFactory;
import nextstep.domain.line.Lines;
import nextstep.domain.line.strategy.TransverseBarStrategy;
import nextstep.domain.track.Tracks;

import java.util.Collections;
import java.util.List;

import static nextstep.domain.line.Lines.TRACK_STEP_SIZE;

public class LadderGameManager {

    private final Tracks tracks;
    private final Lines lines;

    public LadderGameManager(int countOfPerson, int ladderHeight) {
        this.tracks = new Tracks(countOfPerson);
        this.lines = new Lines(LineFactory.createLines(countOfPerson, ladderHeight));
    }

    public LadderGameManager(int countOfPerson, int ladderHeight, TransverseBarStrategy transverseBarStrategy) {
        this.tracks = new Tracks(countOfPerson);
        this.lines = new Lines(LineFactory.createLines(countOfPerson, ladderHeight, transverseBarStrategy));
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

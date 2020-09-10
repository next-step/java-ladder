package nextstep.domain.track;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tracks {

    public static final int FIRST_TRACK_NUMBER = 0;

    private final List<Track> tracks;

    public Tracks(int countOfPerson) {
        this.tracks = IntStream.range(FIRST_TRACK_NUMBER, countOfPerson)
                .mapToObj(Track::new)
                .collect(Collectors.toList());
    }

    public List<Track> getTracks() {
        return Collections.unmodifiableList(tracks);
    }

    public boolean isFirstTrack(int trackNumber) {
        return findTrack(new Track(trackNumber)).isTrackNumber(FIRST_TRACK_NUMBER);
    }

    public boolean isLastTrack(int trackNumber) {
        return findTrack(new Track(trackNumber)).isTrackNumber(tracks.size() - 1);
    }

    private Track findTrack(Track searchTarget) {
        return tracks.stream()
                .filter(searchTarget::equals)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

}

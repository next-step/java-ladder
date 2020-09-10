package nextstep.domain.track;

import java.util.Objects;

public class Track {

    private final int trackNumber;

    public Track(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public boolean isTrackNumber(int trackNumber) {
        return this.trackNumber == trackNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return trackNumber == track.trackNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackNumber);
    }

}

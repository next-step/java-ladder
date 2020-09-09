package nextstep.domain;

import nextstep.domain.track.Track;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("트랙")
public class TrackTest {

    @DisplayName("생성")
    @Test
    public void test() {
        Track expect = new Track(1);
        Track actual = new Track(1);
        assertThat(actual).isEqualTo(expect);
    }

}

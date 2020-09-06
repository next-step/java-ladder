package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("트랙들")
public class TracksTest {

    @DisplayName("생성")
    @Test
    public void create() {
        Tracks tracks = new Tracks(5);
        assertThat(tracks.getTracks()).hasSize(5);
    }

    @DisplayName("첫번째 트랙인지 확인")
    @Test
    public void isFirstTrack() {
        Tracks tracks = new Tracks(5);
        assertThat(tracks.isFirstTrack(0)).isTrue();
    }

    @DisplayName("마지막 트랙인지 확인")
    @Test
    public void isLastTrack() {
        Tracks tracks = new Tracks(5);
        assertThat(tracks.isLastTrack(4)).isTrue();
    }

}

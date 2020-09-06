package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("라인들")
public class LinesTest {

    @DisplayName("생성")
    @Test
    public void create() {
        Lines lines = new Lines(LineFactory.createLines(5, 3, new SwitchDrawTransverseBarStrategy()));
        assertThat(lines.getLines()).hasSize(3);
    }

    @DisplayName("왼쪽으로 갈수 있는지 확인")
    @Test
    public void isPossibleMoveLeftTrack() {
        Lines lines = new Lines(LineFactory.createLines(5, 3, new SwitchDrawTransverseBarStrategy()));
        assertThat(lines.isPossibleMoveLeftTrack(0, 1)).isTrue();
        assertThat(lines.isPossibleMoveLeftTrack(0, 2)).isFalse();
        assertThat(lines.isPossibleMoveLeftTrack(0, 3)).isTrue();
        assertThat(lines.isPossibleMoveLeftTrack(0, 4)).isFalse();
    }

    @DisplayName("오른쪽으로 갈수 있는지 확인")
    @Test
    public void isPossibleMoveRightTrack() {
        Lines lines = new Lines(LineFactory.createLines(5, 3, new SwitchDrawTransverseBarStrategy()));
        assertThat(lines.isPossibleMoveRightTrack(0, 0)).isTrue();
        assertThat(lines.isPossibleMoveRightTrack(0, 1)).isFalse();
        assertThat(lines.isPossibleMoveRightTrack(0, 2)).isTrue();
        assertThat(lines.isPossibleMoveRightTrack(0, 3)).isFalse();
    }

}

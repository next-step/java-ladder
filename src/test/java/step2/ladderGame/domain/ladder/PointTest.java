package step2.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class PointTest {

    @DisplayName("최초생성")
    @Test
    void create_최초생성() {
        assertThat(new Point()).isInstanceOf(Point.class);
        assertThat(new Point().getStatus()).isFalse();
    }

    @DisplayName("추후생성")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void create_추후생성(boolean status) {
        assertThat(new Point(status)).isInstanceOf(Point.class);
    }

    @DisplayName("저장한 status 값을 가져온다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getStatus(boolean status) {
        assertThat(new Point(status).getStatus()).isEqualTo(status);
    }

}

package step3.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.ladderGame.domain.ladder.Point;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class PointTest {

    @DisplayName("최초 생성된 point는 가로선이 없다.")
    @Test
    void create_최초생성() {
        assertThat(new Point()).isInstanceOf(Point.class);
        assertThat(new Point().hasHorizontalLine()).isFalse();
    }

    @DisplayName("추후 생성된 point는 가로선이 랜덤으로 생성된다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void create_추후생성(boolean status) {
        assertThat(new Point(status)).isInstanceOf(Point.class);
    }

    @DisplayName("저장한 status 값을 가져온다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getStatus(boolean status) {
        assertThat(new Point(status).hasHorizontalLine()).isEqualTo(status);
    }

}

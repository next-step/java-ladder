package step2.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void create(boolean status) {
        assertThat(new Point(status)).isInstanceOf(Point.class);
    }

    @DisplayName("저장한 status 값을 가져온다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getStatus(boolean status) {
        assertThat(new Point(status).getStatus()).isEqualTo(status);
    }

}

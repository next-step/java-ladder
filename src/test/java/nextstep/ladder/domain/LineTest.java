package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Line (가로줄)")
class LineTest {

    @DisplayName("[성공] 생성 - with참여자수")
    @ParameterizedTest
    @CsvSource(value = {
        "10"
    })
    public void create_withHeight(int playerCount) {
        // given

        // when
        Line line = Line.of(playerCount);

        // then
        assertThat(line.size()).isEqualTo(playerCount);
        assertThat(line.getExists().get(0)).isFalse();
        assertThat(line.getExists().stream()
            .distinct()
            .count()).isEqualTo(2);
    }
}

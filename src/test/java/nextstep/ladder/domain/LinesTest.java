package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("가로줄들")
class LinesTest {

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @CsvSource(value = {
        "10,5"
    })
    public void create(final int height, final int playerCount) {
        // given

        // when
        final Lines lines = Lines.of(height, playerCount);

        // then
        assertThat(lines.size()).isEqualTo(height);
        assertThat(lines.getLines().get(0).size()).isEqualTo(playerCount + 1);
    }
}

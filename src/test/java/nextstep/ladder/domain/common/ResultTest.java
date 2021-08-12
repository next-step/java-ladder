package nextstep.ladder.domain.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("결과")
class ResultTest {

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @CsvSource(value = {
        "꽝", "5000", "3000"
    })
    public void create(final String value) {
        // given

        // when
        final Result createResult = Result.of(value);

        // then
        assertThat(createResult.getValue()).isEqualTo(value);
    }
}

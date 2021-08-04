package nextstep.ladder.domain.common;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.common.exception.InvalidResultException;
import org.junit.jupiter.api.Assertions;
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

    @DisplayName("[실패] 생성")
    @ParameterizedTest
    @CsvSource(value = {
        "광", "100/"
    })
    public void create_invalidValue(final String value) {
        // given

        // when
        Assertions.assertThrows(InvalidResultException.class, () -> Result.of(value));

        // then
    }
}

package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("결과 입력")
public class WinningTest {

    @Test
    @DisplayName("결과 길이 5 초과 예외 테스트")
    public void validResultLengthTest() throws Exception {
        //given
        String inputWinning = "person,6";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Winnings(inputWinning, 2);
        });

        //then
    }
}

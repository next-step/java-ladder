package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("결과")
public class WinningTest {

    @ParameterizedTest
    @CsvSource(value = {"꽝,꽝,3000,4000:3", "중식,양식,일식,한식,국밥,국밥,국밥:7"}, delimiter = ':')
    @DisplayName("문자열 split 확인")
    public void createWinnerTest(String inputWinning, int check) throws Exception {
        //given
        Winning winning = new Winning(inputWinning);

        //when
        int countOfWinning = winning.readOnlyWinning().size();

        //then
        assertThat(countOfWinning).isEqualTo(check);
    }
}

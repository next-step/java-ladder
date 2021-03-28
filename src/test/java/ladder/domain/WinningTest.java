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
    @CsvSource(value = {"꽝,꽝,3000,4000:4", "중식,양식,일식,한식,국밥,국밥,국밥:7"}, delimiter = ':')
    @DisplayName("문자열 split 확인")
    public void createWinnerTest(String inputWinning, int countOfPerson) throws Exception {
        //given
        Winning winning = new Winning(inputWinning, countOfPerson);

        //when
        int countOfWinning = winning.readOnlyWinning().size();

        //then
        assertThat(countOfWinning).isEqualTo(countOfPerson);
    }

    @Test
    @DisplayName("결과 미입력 예외")
    public void emptyExceptionTest() throws Exception {
        //given
        String inputWinning = "";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Winning(inputWinning, 2);
        });

        //then
    }

    @Test
    @DisplayName("결과 길이 5 초과 예외 테스트")
    public void validResultLengthTest() throws Exception {
        //given
        String inputWinning = "person,6";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Winning(inputWinning, 2);
        });

        //then
    }

    @ParameterizedTest
    @CsvSource(value = {"꽝,꽝,3000,4000:3", "중식,양식,일식,한식,국밥,국밥,국밥:6"}, delimiter = ':')
    @DisplayName("참가자.size != 결과.size 예외")
    public void winningSizeEqualPersonSizeExceptionTest(String inputWinning, int countOfPerson) throws Exception {
        //given

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Winning(inputWinning, 2);
        });

        //then
    }
}

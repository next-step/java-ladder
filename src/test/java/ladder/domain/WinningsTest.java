package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("결과 입력")
public class WinningsTest {

    @ParameterizedTest
    @CsvSource(value = {"꽝,꽝,3000,4000:4", "중식,양식,일식,한식,국밥,국밥,국밥:7"}, delimiter = ':')
    @DisplayName("문자열 split 확인")
    public void createWinnerTest(String inputWinning, int countOfPerson) throws Exception {
        //given
        Winnings winning = new Winnings(inputWinning, countOfPerson);

        //when
        int countOfWinning = winning.readOnlyWinning().size();

        //then
        assertThat(countOfWinning).isEqualTo(countOfPerson);
    }

    @ParameterizedTest
    @CsvSource(value = {"꽝,꽝,3000,4000:4:꽝:0", "중식,양식,일식,한식,국밥,국밥,국밥:7:국밥:6"}, delimiter = ':')
    @DisplayName("결과 찾기 확인")
    public void findWinngingTest(String inputWinnings, int countOfPerson, String inputWinning, int findIndex) throws Exception {
        //given
        Winnings winnings = new Winnings(inputWinnings, countOfPerson);
        Winning result = new Winning(inputWinning);

        //when
        Winning winning = winnings.findWinning(findIndex);

        //then
        assertThat(winning.equals(result)).isTrue();
    }

    @Test
    @DisplayName("결과 미입력 예외")
    public void emptyExceptionTest() throws Exception {
        //given
        String inputWinning = "";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Winnings(inputWinning, 2);
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
            new Winnings(inputWinning, 2);
        });

        //then
    }
}

package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ladder.domain.LadderGameInformation.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGameInformationTest {

    @Test
    @DisplayName("사용자의 이름들, 입력받은 실행결과들을 문자열로 받아 ','를 기준으로 나눈 List<String>을 반환")
    void should_return_divided_string() {
        //Given
        String names = "pobi,honux,crong,jk";
        String results = "꽝,5000,꽝,3000";

        //When
        LadderGameInformation ladderGameInformation = new LadderGameInformation(names, results);

        //Then
        assertThat(ladderGameInformation.getParticipants()).containsAll(Arrays.asList("pobi", "honux", "crong", "jk"));
        assertThat(ladderGameInformation.getResults()).containsAll(Arrays.asList("꽝", "5000", "꽝", "3000"));
    }

    @Test
    @DisplayName("이름에 공백이 들어가면 Exception을 throw한다.")
    void should_throw_exception_when_name_is_blank() {
        //Given
        String names = "pobi,    ";
        String results = "꽝,5000,꽝,3000";

        //Given & When
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGameInformation(names, results))
                .withMessage(INPUT_CAN_NOT_BE_BLANK);
    }

    @Test
    @DisplayName("중복되는 이름을 입력하면, Exception을 throw한다.")
    void should_throw_exception_when_name_is_duplcated() {
        //Given
        String names = "pobi,pobi,poby,bopi,bopy";
        String results = "꽝,5000,꽝,3000";

        //When
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGameInformation(names, results))
                .withMessage(NAMES_CANNOT_BE_DUPLICATED);
    }

    @Test
    @DisplayName("5글자 이상의 이름을 입력하면, Exception을 throw한다.")
    void should_throw_exception_when_name_is_too_long() {

        //Given
        String names = "guylian, operabean, hoonick";
        String results = "꽝,5000,꽝,3000";

        //Given & When
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGameInformation(names, results))
                .withMessage(NAME_IS_TOO_LONG);
    }


    @Test
    @DisplayName("실행결과에 공백이 있으면 exception을 throw 한다.")
    void should_throw_exception_when_result_is_blank() {
        //Given
        String names = "pobi,honux,crong,jk";
        String results = "꽝,5000,,   ";

        //When
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGameInformation(names, results))
                .withMessage(INPUT_CAN_NOT_BE_BLANK);
    }


}
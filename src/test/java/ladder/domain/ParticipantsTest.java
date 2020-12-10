package ladder.domain;

import ladder.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantsTest {

    @Test
    @DisplayName("사용자의 이름들을 문자열로 받아 ','를 기준으로 나눈 List<String>을 반환")
    void should_return_divided_string() {
        //Given
        String names = "pobi,honux,crong,jk";

        //When
        Participants participants = new Participants(names);

        //Then
        assertThat(participants.getValue()).containsAll(Arrays.asList("pobi", "honux", "crong", "jk"));
    }

    @ParameterizedTest
    @DisplayName("이름에 공백이 들어가면 Exception을 throw한다.")
    @ValueSource(strings = {"pobi,    ", "", "     "})
    void should_throw_exception_when_name_is_blank(String names) {
        //Given & When
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(names))
                .withMessage(ErrorMessage.NAME_CAN_NOT_BE_BLANK);
    }

    @Test
    @DisplayName("중복되는 이름을 입력하면, Exception을 throw한다.")
    void should_throw_exception_when_name_is_blank() {
        //Given & When
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants("pobi,pobi,poby,bopi,bopy"))
                .withMessage(ErrorMessage.NAMES_CANNOT_BE_DUPLICATED);
    }

}
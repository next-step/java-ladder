package nextstep.ladder;

import ladder.domain.*;
import ladder.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonsTest {

    @Test
    @DisplayName("사람 쉼표로 구분하여 입력후 사람수 정확한지 테스트 ")
    void countPersonTest(){
        Persons persons = Persons.of("pobi,honux,crong,jk");
        assertThat(persons.count()).isEqualTo(4);
    }

    @Test
    @DisplayName("사람수 유효성 테스트 ")
    void countPersonExceptionTest(){
        assertThatThrownBy(() -> Persons.of("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Persons.LADDER_GAME_MINIMUM_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("입력값 null 또는 비어있을 경우 테스트 ")
    @NullAndEmptySource
    void inputPersonsNullTest(String inputPersons){
        assertThatThrownBy(() -> Persons.of(inputPersons))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(StringUtil.EMPTY_WORDS_EXCEPTION);
    }
}

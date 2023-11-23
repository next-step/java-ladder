package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTextsTest {
    @Test
    @DisplayName("참여할 사람들의 이름을 입력으로 UserInputTexts 객체를 생성할 수 있다.")
    void testUserInputTextsConstructor() {
        //given
        final String userNamesText = "pobi,honux,crong,jk";

        //when
        final UserInputTexts userInputTexts = new UserInputTexts(userNamesText);

        //then
        assertThat(userInputTexts).isNotNull();
    }

    @Test
    @DisplayName("참여할 사람들의 이름 중 " + UserInputTexts.MAX_TEXT_LENGTH + "글자가 넘는 이름이 있으면, IllegalArgumentException이 발생한다.")
    void testUserInputTextsConstructorWithExceptionIfNameLengthIsLongerThan5() {
        //given
        final String userNamesText = "pobi,honux,crong,jk,pooobie";

        //when, then
        assertThatThrownBy(() -> new UserInputTexts(userNamesText))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 및 실행결과는 " + UserInputTexts.MAX_TEXT_LENGTH + "글자까지만 허용합니다.");
    }
}

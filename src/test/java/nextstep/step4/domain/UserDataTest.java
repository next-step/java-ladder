package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserDataTest {
    @Test
    @DisplayName("UserNames와 UserResults를 사용해서 UserData 객체를 생성한다.")
    void testUserDataConstructor() {
        //given
        final UserInputTexts userNames = new UserInputTexts("pobi,honux,crong,jk");
        final UserInputTexts userResults = new UserInputTexts("꽝,5000,꽝,3000");

        //when
        final UserData userData = new UserData(userNames, userResults);

        //then
        assertThat(userData).isNotNull();
    }
}

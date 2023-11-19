package nextstep.ladder.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class UserNamesTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk", "A,B,C", "12-34,1-2-3,123"})
    @DisplayName("사람 이름을 ','로 구분해서 넣으면, 사람 이름을 저장한 UserNames 객체가 생성된다")
    void testUserNamesConstructor(String text) {
        //given
        //when
        UserNames userNames = new UserNames(text);

        //then
        assertThat(userNames).isNotNull();
        assertThat(userNames.getNames()).containsExactlyElementsOf(Arrays.asList(text.split(",")));
    }

}

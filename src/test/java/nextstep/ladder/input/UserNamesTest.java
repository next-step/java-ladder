package nextstep.ladder.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNamesTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk", "A,B,C", "1,2,3,45-67,8-9-0"})
    @DisplayName("사람 이름을 ','로 구분해서 넣으면, 사람 이름을 저장한 UserNames 객체가 생성된다")
    void testUserNamesConstructor(String text) {
        //given
        //when
        UserNames userNames = new UserNames(text);

        //then
        assertThat(userNames).isNotNull();
        assertThat(userNames.names()).containsExactlyElementsOf(Arrays.asList(text.split(",")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobibb,honux,crong,jk", "A,B,C,DEFGHI", "12-34-1,2,3,4"})
    @DisplayName("사람 이름 중 5글자를 넘는 이름이 있으면, IllegalArgumentException이 발생한다")
    void throwIllegalArgumentExceptionIfNameIsLongerThan5(String text) {
        //given, when, then
        assertThatThrownBy(() -> new UserNames(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "A"})
    @DisplayName("사람 이름이 2개 미만이면, IllegalArgumentException이 발생한다")
    void throwIllegalExceptionIfNameCountIsLessThan2(String text) {
        //given, when, then
        assertThatThrownBy(() -> new UserNames(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 2명 이상이 필요합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk", "A,B,C", "1,2,3,4,5,6"})
    @DisplayName("size() 메서드를 사용하면, 몇개의 이름이 저장되어 있는지 반환한다.")
    void testSize(String text) {
        //given
        final int expectedSize = text.split(",").length;

        //when
        UserNames userNames = new UserNames(text);

        //then
        assertThat(userNames.size()).isEqualTo(expectedSize);
    }
}

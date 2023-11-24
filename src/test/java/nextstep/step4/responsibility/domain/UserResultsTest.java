package nextstep.step4.responsibility.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserResultsTest {
    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝,3000", "1000,500,100,3000", "1,2,3,4"})
    @DisplayName("결과를 ','로 구분해서 넣으면, 결과를 저장한 UserResults 객체가 생성된다")
    void testUserResultsConstructor(String text) {
        //given
        //when
        UserResults userResults = new UserResults(text);

        //then
        assertThat(userResults).isNotNull();
        assertThat(userResults.getList()).containsExactlyElementsOf(Arrays.asList(text.split(",")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝이 되었습니다.,1000,100000,0", "A,B,C,DEFGHI", "12-34-1,2,3,4"})
    @DisplayName("결과 중 5글자를 넘는 결과가 있으면, IllegalArgumentException이 발생한다")
    void throwIllegalArgumentExceptionIfResultIsLongerThan5(String text) {
        //given, when, then
        assertThatThrownBy(() -> new UserResults(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 " + UserResults.MAX_RESULT_LENGTH + "글자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk", "A,B,C", "1,2,3,4,5,6"})
    @DisplayName("size() 메서드를 사용하면, 몇개의 이름이 저장되어 있는지 반환한다.")
    void testSize(String text) {
        //given
        final int expectedSize = text.split(",").length;

        //when
        UserResults userResults = new UserResults(text);

        //then
        assertThat(userResults.size()).isEqualTo(expectedSize);
    }
}

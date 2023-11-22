package nextstep.ladder.domain;

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
        UserResults userResults = new UserResults(text, 4);

        //then
        assertThat(userResults).isNotNull();
        assertThat(userResults.results()).containsExactlyElementsOf(Arrays.asList(text.split(",")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "A"})
    @DisplayName("입력한 결과의 수가 전달받은 참여 인원 수와 다르면, IllegalArgumentException이 발생한다")
    void throwIllegalExceptionIfResultsCountIsNotEqualToUserNamesCount(String text) {
        //given, when, then
        assertThatThrownBy(() -> new UserResults(text, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여 인원수와 동일한 수의 결과를 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝이 되었습니다.,1000,100000,0", "A,B,C,DEFGHI", "12-34-1,2,3,4"})
    @DisplayName("결과 중 5글자를 넘는 결과가 있으면, IllegalArgumentException이 발생한다")
    void throwIllegalArgumentExceptionIfResultIsLongerThan5(String text) {
        //given, when, then
        assertThatThrownBy(() -> new UserResults(text, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 " + UserNames.NAME_MAX_LENGTH + "글자 이하만 가능합니다.");
    }
}

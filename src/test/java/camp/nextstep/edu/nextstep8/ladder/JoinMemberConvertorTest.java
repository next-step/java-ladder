package camp.nextstep.edu.nextstep8.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JoinMemberConvertorTest {
    @DisplayName("참가자 문자열이 제대로 변환 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "A,B,C,D,E:5",
            "apple,bread,car,dry,egg:5",
            "boy,girl:2"
    }, delimiter = ':')
    public void makeJoinMembersTest(String joinMembersStr, int expectedCount) {
        // when
        List<String> joinMembers = JoinMemberConvertor.makeJoinMembers(joinMembersStr);

        // then
        assertThat(joinMembers.size()).isEqualTo(expectedCount);
    }

    @DisplayName("빈 문자 열일 경우 예외")
    @Test
    public void makeJoinMemberEmptyTest() {
        // when & then
        assertThatThrownBy(() -> JoinMemberConvertor.makeJoinMembers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자가 없습니다");
    }

    @DisplayName("최대 글자 수를 초과 하였을 경우 예외")
    @Test
    public void makeJoinMemberExceedLimitTest() {
        // given
        String joinMembersStr = "abcde,123456";

        // when & then
        assertThatThrownBy(() -> JoinMemberConvertor.makeJoinMembers(joinMembersStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 글자 수를 초과 하였습니다 : 123456");
    }
}
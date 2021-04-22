package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class MembersTest {

    @Test
    @DisplayName("두 명 미만의 사용자가 참여하면 오류 발생")
    void createMembersTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Members.of("asd"))
                .withMessage("두 명 이상의 사용자가 참여해야 합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 공백이거나 null이면 오류 발생")
    void createMemberTest2(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Members.of(name))
                .withMessage("이름은 공백이 될 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"a,0", "b,1", "c,2"})
    @DisplayName("몇 번째 참가자인지 index를 반환한다.")
    void indexOfMemberTest(String findName, int index) {
        Members members = Members.of("a,b,c");
        assertThat(members.indexOf(new Member(findName))).isEqualTo(index);
    }
}

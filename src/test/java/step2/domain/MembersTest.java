package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
    void createMemberTest2(String name){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Members.of(name))
                .withMessage("이름을 입력해주세요.");
    }
}
package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderMemberTest {
    @Test
    @DisplayName("사람의 이름으로 사다리 멤버가 생성된다.")
    void inputName_CreateLadderMemberTest_isEqualToMember() {
        LadderMember member = new LadderMember("pobi1");
        assertThat(member).isEqualTo(new LadderMember("pobi1"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"pobiho", "boradol"})
    @DisplayName("사람 이름이 5자 초과하면 에러 발생한다.")
    void inputName_greaterThanMaxLengthTest(String input) {
        assertThatThrownBy(() -> new LadderMember(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하로 입력해야 합니다.");
    }

}

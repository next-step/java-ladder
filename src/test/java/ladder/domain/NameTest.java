package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("사다리 참가자 입력 받은 사람 이름 정상 노출 되는지 확인")
    public void 입력받은_사람_이름_정상확인() {
        Name name = Name.of("yu");
        assertThat(name.getName()).isEqualTo("yu");
    }

    @ParameterizedTest
    @DisplayName("사다리 참가자 입력 받은 사람 이름 5글자 이상인 경우 예외")
    @ValueSource(strings = {"abcdeff", "qweasdffsd"})
    public void 입력받은_사람_이름_5글자이상(String name) {
        assertThatThrownBy(() -> Name.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여할 사람 이름 최대 길이는 5글자 입니다.");
    }

    @ParameterizedTest
    @DisplayName("사다리 참가자 입력 받은 사람 이름 빈 값인 경우 예외")
    @ValueSource(strings = {""})
    public void 입력받은_사람_이름_빈(String name) {
        assertThatThrownBy(() -> Name.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여할 사람 이름을 입력해주세요.");
    }
}

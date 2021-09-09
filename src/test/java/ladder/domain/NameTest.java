package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 게임 참가자의 이름을 가지는 Name 클래스 테스트")
public class NameTest {
    @DisplayName("비어있는 String은 유효한 이름이 아니다.")
    @ParameterizedTest(name = "{arguments} : {displayName}")
    @NullAndEmptySource
    void isBlank(String name) {
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 길이가 5글자 이상이면 유효한 이름이 아니다.")
    @Test
    void nameSize() {
        assertThat(new Name("abcde"));
        assertThatThrownBy(() ->  new Name("abcdef")).isInstanceOf(IllegalArgumentException.class);
    }
}

package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NameTest {
    @DisplayName("사용자 명 생성 테스트")
    @Test
    void create_사용자_명() {
        // given
        Name name = Name.of("seok");
        // when
        Name expected = Name.of("seok");
        // then
        assertThat(name).isEqualTo(expected);
    }

    @DisplayName("사용자 명 생성시 예외 테스트")
    @Test
    void create_Exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> Name.of("123456"));
    }
}

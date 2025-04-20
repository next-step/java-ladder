package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonNameTest {
    @DisplayName("사용자 이름 생성")
    @Test
    public void personName() throws Exception {
        assertThat(new PersonName("12345").getName())
                .isEqualTo("12345");
    }

    @DisplayName("사용자 이름 생성 실패, null")
    @Test
    public void personNameNull() throws Exception {
        assertThatThrownBy(() -> new PersonName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Name cannot be null or empty");

        assertThatThrownBy(() -> new PersonName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Name cannot be null or empty");
    }

    @DisplayName("사용자 이름 생성 실패, 최대 길이 초과")
    @Test
    public void personNameMaxLength() throws Exception {
        assertThatThrownBy(() -> new PersonName("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Name is too long");
    }
}
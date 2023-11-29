package nextstep.ladder.model;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonCountTest {

    @Test
    @DisplayName("사람의 수는 1 이상 이어야 합니다.")
    void person_count() {
        Assertions.assertThatThrownBy(() -> {
                new PersonCount(0);
            }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사람의 수는 1 이상 이어야 합니다.");

        Assertions.assertThatThrownBy(() -> {
                new PersonCount(-1);
            }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사람의 수는 1 이상 이어야 합니다.");
    }
}
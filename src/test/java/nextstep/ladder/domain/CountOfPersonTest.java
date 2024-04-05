package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CountOfPersonTest {

    @Test
    void countOfPerson() {
        assertThat(new CountOfPerson(1)).isEqualTo(new CountOfPerson(1));
    }

    @Test
    void countOfPersonException() {
        int negative = -10;

        assertThatThrownBy(() -> new CountOfPerson(negative))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("사람의 수(%d)는 음수가 될 수 없습니다", negative));
    }

}

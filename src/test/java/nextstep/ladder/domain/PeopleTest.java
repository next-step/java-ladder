package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PeopleTest {
    @Test
    @DisplayName("이름이 5글자가 넘어가면 IllegalArgumentException 발생한다.")
    void name() {
        assertThatThrownBy(() -> {
            String name = "testtest";
            new People(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

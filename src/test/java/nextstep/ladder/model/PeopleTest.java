package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PeopleTest {
    @Test
    @DisplayName("사람은 최소 1명 이상이다.")
    void test1() {
        assertThatThrownBy(() -> new People(new ArrayList<>()))
                .hasMessageContaining("사람은 최소 1명 이상");
    }
}
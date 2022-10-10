package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NamesTest {

    @DisplayName("쉼표를 기준으로 이름을 구분할 수 있다.")
    @Test
    void names() {
        Names names = new Names("test1, test2,test3");

        assertThat(names.values()).contains(Name.of("test1"), Name.of("test2"), Name.of("test3"));
    }
}
package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("참여자수, 높이 배열크기의 사다리 생성")
    @Test
    void create() {
        assertThat(new Ladder(4, 5).valueOfLines().size()).isEqualTo(5);
    }
}
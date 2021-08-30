package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

    @DisplayName("참여자수, 높이에 따라 사다리 생성")
    @Test
    void create() {
        assertThat(new Ladder(4, 5, new RandomPointCreator()).valueOfLines().size()).isEqualTo(5);
    }

    @DisplayName("참여자수 또는 높이가 0일때 생성하지 못한다.")
    @Test
    void create_error() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0, 1, new RandomPointCreator()));
    }
}
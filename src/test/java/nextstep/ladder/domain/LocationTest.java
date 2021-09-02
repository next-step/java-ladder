package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocationTest {

    @DisplayName("플레이어 위치를 나타내는 Location 객체")
    @Test
    void create() {
        assertThat(new Location(3)).isEqualTo(new Location(3));
    }

    @DisplayName("음수위치는 생성할 수 없다.")
    @Test
    void create_error() {
        assertThrows(IllegalArgumentException.class, () -> new Location(-1));
    }
}
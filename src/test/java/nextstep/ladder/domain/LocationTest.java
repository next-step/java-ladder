package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LocationTest {

    @DisplayName("플레이어 위치를 나타내는 Location 객체")
    @Test
    void create(){
        assertThat(new Location(3)).isEqualTo(new Location(3));
    }
}
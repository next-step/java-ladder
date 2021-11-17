package nextstep.ladder.domain;

import nextstep.ladder.doamin.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {

    @Test
    @DisplayName("증가값 검증")
    void increaseLocation() {
        Location location = Location.from(0);
        assertThat(location.increaseLocation()).isEqualTo(Location.from(1));
    }

    @Test
    @DisplayName("감소값 검증")
    void decreaseLocation() {
        Location location = Location.from(1);
        assertThat(location.decreaseLocation()).isEqualTo(Location.from(0));
    }

}

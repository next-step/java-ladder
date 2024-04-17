package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CurrentLocationTest {
    public static final CurrentLocation location = new CurrentLocation(0);

    @Test
    @DisplayName("참가자 위치 이동 테스트")
    void updateLocationTest() {
        location.updateLocation(DirectionTest.RIGHT);
        assertThat(location.getLocation()).isEqualTo(1);
        location.updateLocation(DirectionTest.LEFT);
        assertThat(location.getLocation()).isEqualTo(0);
    }
}
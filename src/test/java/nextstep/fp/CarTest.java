package nextstep.fp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    public static final String POBI_NAME = "pobi";

    Car pobi;

    @BeforeEach
    void setUp() {
        pobi = new Car(POBI_NAME, 0);
    }

    @Test
    @DisplayName("이동 테스트")
    void move() {
        // given
        // when
        Car actual = pobi.move(() -> true);

        // then
        assertThat(actual).isEqualTo(new Car(POBI_NAME, 1));
    }

    @Test
    @DisplayName("정지 테스트")
    void nonMove() {
        // given
        // when
        Car actual = pobi.move(() -> false);

        // then
        assertThat(actual).isEqualTo(new Car(POBI_NAME, 0));
    }
}

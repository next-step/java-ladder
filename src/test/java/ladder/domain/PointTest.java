package ladder.domain;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @DisplayName("둘 다 true인지 테스트")
    public void getPersonLocaiontNoPerson(String target) {
        assertThatThrownBy(() -> {
            Point point = new Point(true,true);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

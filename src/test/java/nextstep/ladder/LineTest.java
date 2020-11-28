package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {
    @Test
    void create() {
        assertThat(Spoke.of(true, false, true).toLine()).isNotNull();
    }

    @DisplayName("오른쪽에 발판이 존재하는지 알 수 있다")
    @Test
    void hasSpokeRightSide() {
        Line line = Spoke.of(true, false, true).toLine();
        assertAll(
                () -> assertThat(line.hasSpokeRightSide(Position.of(0))).isTrue(),
                () -> assertThat(line.hasSpokeRightSide(Position.of(1))).isFalse(),
                () -> assertThat(line.hasSpokeRightSide(Position.of(2))).isTrue()
        );
    }

    @DisplayName("발판은 갯수로 생성할 수 있다.")
    @Test
    void createSpokeFromCount() {
        assertThat(Spoke.fromCount(3, createTestingObject(true, false, true))).isNotNull();
    }

    @DisplayName("제네레이터을 통해 생성한 값을 테스트한다")
    @Test
    void spokeCreateFromGenerator() {
        assertThat(Spoke.fromCount(3, createTestingObject(true, false, true)))
                .isEqualTo(Spoke.of(true, false, true));
    }

    private TestingBooleanGenerator createTestingObject(Boolean... booleans) {
        return new TestingBooleanGenerator(booleans);
    }
}

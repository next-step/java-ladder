package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    @DisplayName("사다리 생성 테스트")
    void create(int height) {
        Ladder ladder = new Ladder(Height.from(height), 3, new DirectionRandomPredicate());
        assertThat(ladder.getLines()).hasSize(height);
        assertThat(ladder.getLines().get(0).getPoints()).isNotNull();
        assertThat(ladder.getHeight()).isEqualTo(height);
    }

    @Test
    @DisplayName("ladder 클래스 생성 예외 테스트(높이)")
    void exception_height() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lines(Height.from(0), 3, new DirectionRandomPredicate()));
    }

    @Test
    @DisplayName("lines 클래스 생성 예외 테스트(사람 수)")
    void exception_size_of_person() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lines(Height.from(1), 1, new DirectionRandomPredicate()));
    }


    @ValueSource(ints = {0, 1, 2})
    @ParameterizedTest
    @DisplayName("사다리 도착지 메소드 테스트")
    void findDestination(int startPosition) {
        int maxPosition = 3;
        Ladder ladder = new Ladder(Height.from(5), maxPosition, new DirectionRandomPredicate());
        int destinationOrder = ladder.findDestinationPosition(startPosition);
        assertThat(destinationOrder).isNotNull();
        assertThat(destinationOrder).isLessThanOrEqualTo(maxPosition);
    }

    @ValueSource(ints = {0, 1, 2})
    @ParameterizedTest
    @DisplayName("사다리 도착지점 예상 테스트")
    void findDestinationPredicate(int startPosition) {
        int maxPosition = 3;
        Ladder ladder = new Ladder(Height.from(5), maxPosition, () -> false);
        int destinationOrder = ladder.findDestinationPosition(startPosition);
        assertThat(destinationOrder).isEqualTo(startPosition);
    }
}

package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderLineCreatorImplTest {

    private final RandomValueGenerator trueGenerator = () -> true;
    private final LadderLineCreator target = new LadderLineCreatorImpl(trueGenerator);

    @DisplayName("주어진 포인트 사이즈 수만큼 포인트를 가지고있는 사다리 라인을 만들수 있어야 한다")
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 10})
    void create(final int pointsSize) {
        assertThat(target.create(new PositiveNumber(pointsSize)).size()).isEqualTo(pointsSize);
    }

}
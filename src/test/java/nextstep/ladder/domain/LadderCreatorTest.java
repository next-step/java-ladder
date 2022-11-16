package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderCreatorTest {

    private final RandomValueGenerator trueGenerator = () -> true;
    private final LadderLineCreator ladderLineCreator = new LadderLineCreator(trueGenerator);
    private final LadderCreator target = new LadderCreator(ladderLineCreator);

    @DisplayName("주어진 사다리 넓이와 높이를 가진 사다리를 생성할 수 있어야 한다")
    @ParameterizedTest
    @CsvSource(value = {
        "1:2",
        "1:5",
        "1:10",
        "5:2",
        "5:5",
        "10:10",
    }, delimiter = ':')
    void create(final int ladderHeight, final int ladderWidth) {
        final Ladder ladder = target.create(new PositiveNumber(ladderHeight), new PositiveNumber(ladderWidth));
        assertThat(ladder.getHeight()).isEqualTo(ladderHeight);
        assertThat(ladder.getWidth()).isEqualTo(ladderWidth);
    }
}
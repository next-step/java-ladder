package ladder.model;

import ladder.model.ladder.Ladder;
import ladder.model.participant.Names;
import ladder.model.result.LadderResults;
import ladder.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGameTest {

    @Test
    public void 참가자_수는_사다리_너비보다_1만큼_더_커야_한다() {
        Names names = Names.of("test1", "test2");
        Ladder ladder = Ladder.create(1, 2, new RandomStrategy());
        LadderResults results = LadderResults.of("test1", "test2");

        assertThatCode(() -> new LadderGame(names, ladder, results))
                .doesNotThrowAnyException();
    }

    @Test
    public void 참가자는_최소_2명이어야_한다() {
        Names names = Names.of("test1");
        Ladder ladder = Ladder.create(1, 2, new RandomStrategy());
        LadderResults results = LadderResults.of("test1", "test2");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(names, ladder, results));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    public void 참가자_수와_사다리_너비가_맞지_않으면_예외가_난다(int width) {
        Names names = Names.of("test1", "test2");
        Ladder ladder = Ladder.create(width, 2, new RandomStrategy());
        LadderResults results = LadderResults.of("test1", "test2");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(names, ladder, results));
    }

    @Test
    public void 참가자_수와_결과_개수가_같지_않으면_예외가_난다() {
        Names names = Names.of("test1", "test2");
        Ladder ladder = Ladder.create(1, 2, new RandomStrategy());

        LadderResults results = LadderResults.of("test1");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(names, ladder, results));
    }
}
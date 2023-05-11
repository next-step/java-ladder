package ladder.model;

import ladder.model.ladder.Ladder;
import ladder.model.ladder.LadderRow;
import ladder.model.participant.Name;
import ladder.model.participant.Names;
import ladder.model.result.LadderResult;
import ladder.model.result.LadderResults;
import ladder.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    public void 사다리_게임_결과를_제대로_구할_수_있다() throws Exception {
        //given
        Name player1 = new Name("name1");
        Name player2 = new Name("name2");
        Name player3 = new Name("name3");
        Names names = Names.of(player1, player2, player3);

        LadderResult result1 = new LadderResult("result1");
        LadderResult result2 = new LadderResult("result2");
        LadderResult result3 = new LadderResult("result3");
        LadderResults results = LadderResults.of(result1, result2, result3);

        LadderRow row1 = LadderRow.of(false, true);     // |   |---|
        LadderRow row2 = LadderRow.of(false, false);    // |   |   |
        Ladder ladder = Ladder.of(row1, row2);

        LadderGame game = new LadderGame(names, ladder, results);

        //when, then
        assertThat(game.resultOf(player1)).isEqualTo(result1);
        assertThat(game.resultOf(player2)).isEqualTo(result3);
        assertThat(game.resultOf(player3)).isEqualTo(result2);
    }

    @Test
    public void 참가자_수는_사다리_기둥_수와_같아야_한다() {
        Names names = Names.of("test1", "test2");
        Ladder ladder = Ladder.create(2, 2, new RandomStrategy());
        LadderResults results = LadderResults.of("test1", "test2");

        assertThatCode(() -> new LadderGame(names, ladder, results))
                .doesNotThrowAnyException();
    }

    @Test
    public void 참가자는_최소_2명이어야_한다() {
        Names names = Names.of("test1");
        Ladder ladder = Ladder.create(2, 2, new RandomStrategy());
        LadderResults results = LadderResults.of("test1", "test2");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(names, ladder, results));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4})
    public void 참가자_수와_사다리_기둥_수가_맞지_않으면_예외가_난다(int stiles) {
        Names names = Names.of("test1", "test2", "test3");
        Ladder ladder = Ladder.create(stiles, 2, new RandomStrategy());
        LadderResults results = LadderResults.of("test1", "test2", "test3");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(names, ladder, results));
    }

    @Test
    public void 참가자_수와_결과_개수가_같지_않으면_예외가_난다() {
        Names names = Names.of("test1", "test2");
        Ladder ladder = Ladder.create(2, 2, new RandomStrategy());

        LadderResults results = LadderResults.of("test1");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(names, ladder, results));
    }
}
package ladder.domain.result;

import ladder.domain.player.Name;
import ladder.domain.player.Player;
import ladder.domain.reward.Reward;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {
    @ParameterizedTest
    @NullAndEmptySource
    void Results는_results_없이_생성_할_경우_예외를_발생_시킨다(List<Result> results) {
        assertThatThrownBy(
                () -> new Results(results)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void findByPlayerName은_playerName으로_result를_반환한다() {
        Result expectedResult = Result.of(
                new Player("name", 0),
                new Reward("1", 0)
        );
        Results results = new Results(List.of(expectedResult,
                Result.of(
                        new Player("이름", 0),
                        new Reward("1", 0)
                )
        ));


        Result result = results.findByPlayerName(Name.valueOf("name"));

        assertThat(result).isEqualTo(expectedResult);
    }

}

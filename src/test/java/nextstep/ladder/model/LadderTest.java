package nextstep.ladder.model;

import nextstep.ladder.factory.LinesFactory;
import nextstep.ladder.generator.LineGenerator;
import nextstep.ladder.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {


    Players players;
    Lines lines;
    Results results;

    @BeforeEach
    void setUp() {
        //given
        String inputNames = "pobi,honux";
        String inputResults = "꽝,5000";
        String[] splitNames = StringUtils.validationNotNullAndEmpty(inputNames).split(",");
        String[] splitResults = StringUtils.validationNotNullAndEmpty(inputResults).split(",");
        int width = splitNames.length;
        int height = 1;
        LineGenerator generator = prev -> !prev;

        players = new Players(splitNames);
        lines = LinesFactory.of(true, width, height, generator);
        results = new Results(splitResults, width);
    }

    @Test
    @DisplayName("사다리게임 생성 실패")
    void validationIsNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Ladder(null, lines, results));
    }

    @Test
    @DisplayName("사다리게임 결과 확인")
    void game() {
        Ladder ladder = new Ladder(players, lines, results);
        Report report = ladder.game();

        Player pobiPlayer = players.findPlayerByName("pobi");
        Result pobiResult = report.findResultByPlayerName("pobi");

        assertThat(pobiResult.equalsIndex(pobiPlayer.getIndex())).isTrue();
    }
}
package nextstep.ladder;

import nextstep.ladder.factory.LinesFactory;
import nextstep.ladder.model.*;
import nextstep.ladder.utils.StringUtils;
import nextstep.ladder.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private static final String DELIMITER = ",";

    @ParameterizedTest
    @CsvSource(value = {"0,pobi", "1,honux", "2,crong", "3,jk"})
    @DisplayName("통합 테스트")
    void integrationTest(int index, String name) {
        String inputNames = "pobi,honux,crong,jk";
        String[] splitNames = StringUtils.validationNotNullAndEmpty(inputNames).split(DELIMITER);
        Players players = new Players(splitNames);
        int width = splitNames.length;

        String inputResults = "꽝,5000,꽝,꽝";
        String[] splitResults = StringUtils.validationNotNullAndEmpty(inputResults).split(DELIMITER);
        Results results = new Results(splitResults, width);

        int height = 4;
        Lines lines = LinesFactory.of(true, width, height, prev -> !prev); // 제자리로 돌아오는 사다리

        Ladder ladder = new Ladder(players, lines, results);
        Report report = ladder.game();

        OutputView.print(report);
        assertThat(players.findPlayerByIndex(new Index(index))).isEqualTo(new Player(name, index));
    }
}
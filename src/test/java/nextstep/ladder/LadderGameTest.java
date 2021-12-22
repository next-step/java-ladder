package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Lines;
import nextstep.ladder.model.Players;
import nextstep.ladder.model.Results;
import nextstep.ladder.utils.StringUtils;
import nextstep.ladder.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    private static final String DELIMITER = ",";

    @Test
    @DisplayName("랜덤으로 잘 그려지는지 테스트")
    void ladderDrawTest() {
        String inputNames = "pobi,honux,crong,jk,adsfa,qfadg,qszcq,dafda,11231";
        String[] splitNames = StringUtils.validationNotNullAndEmpty(inputNames).split(DELIMITER);
        Players players = new Players(splitNames);
        int width = splitNames.length;

        String inputResults = "꽝,5000,꽝,꽝,꽝,꽝,꽝,꽝,10000";
        String[] splitResults = StringUtils.validationNotNullAndEmpty(inputResults).split(DELIMITER);
        Results results = new Results(splitResults, width);

        int height = 10;
        Lines lines = LinesFactory.of(width, height);

        Ladder ladder = new Ladder(players, lines, results);

        OutputView.print(ladder);
    }
}
package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    @Test
    @DisplayName("통합 테스트")
    void IntegrationTest() {
        String inputNames = "pobi,honux,crong,jk,adsfa,qfadg,qszcq,dafda,11231";
        int height = 10;

        Ladder ladder = new Ladder(inputNames, height);

        OutputView.print(ladder);
    }
}
package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PlayerNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTests {
    @DisplayName("PlayerNames, Ladder 객체를 주입받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        PlayerNames playerNames = PlayerNames.create("poppo, ita");
        int maxLadderHeight = 5;
        Ladder ladder = Ladder.create(maxLadderHeight, playerNames.size());

        OutputView outputView = new OutputView(playerNames, ladder);

        assertThat(outputView).isNotNull();
    }
}

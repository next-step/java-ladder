package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
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

    @DisplayName("Line 한 줄을 출력할 수 있다. 이때 사다리의 폭은 현재 이름 중 가장 긴 이름을 기준으로 그린다.")
    @Test
    void drawLineTest() {
        // PlayerNames에서 생성한 사이즈가 이상한지 Line 생성한 사이즈가 이상한지 확인할 것
        PlayerNames playerNames = PlayerNames.create("poppo, ita");
        int maxLadderHeight = 5;
        Ladder ladder = Ladder.create(maxLadderHeight, playerNames.size());
        OutputView outputView = new OutputView(playerNames, ladder);

        Line line = Line.create(playerNames.size());
        assertThat(line.size()).isEqualTo(2);

        String drawResult = outputView.drawLine(line);

        assertThat(drawResult).isEqualTo("     |-----|");
    }

    @DisplayName("Ladder 전체를 출력할 수 있다. 이때 사다리의 폭은 현재 이름 중 가장 긴 이름을 기준으로 그린다.")
    @Test
    void drawLadderTest() {
        PlayerNames playerNames = PlayerNames.create("poppo, ita");
        int maxLadderHeight = 5;
        Ladder ladder = Ladder.create(maxLadderHeight, playerNames.size());
    }
}

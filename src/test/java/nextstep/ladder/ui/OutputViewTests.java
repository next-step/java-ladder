package nextstep.ladder.ui;

import nextstep.ladder.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTests {
    private PointAddStrategy simplePointAddStrategy;
    private PlayerNames playerNames;
    private Ladder ladder;

    @BeforeEach
    public void setup() {
        simplePointAddStrategy = new SimplePointAddStrategy();
        playerNames = PlayerNames.create("poppo, ita");
        int maxLadderHeight = 5;
        ladder = Ladder.create(maxLadderHeight, playerNames.size(), simplePointAddStrategy);
    }

    @DisplayName("PlayerNames, Ladder 객체를 주입받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        OutputView outputView = new OutputView(playerNames, ladder);

        assertThat(outputView).isNotNull();
    }

    @DisplayName("Line 한 줄을 출력할 수 있다. 이때 사다리의 폭은 현재 이름 중 가장 긴 이름을 기준으로 그린다.")
    @Test
    void drawLineTest() {
        OutputView outputView = new OutputView(playerNames, ladder);

        Line line = LineFactory.create(playerNames.size(), simplePointAddStrategy);
        assertThat(line.size()).isEqualTo(2);

        String drawResult = outputView.parseLine(line);

        assertThat(drawResult).isEqualTo("     |-----|");
    }

    @DisplayName("Ladder 전체를 출력할 수 있다. 이때 사다리의 폭은 현재 이름 중 가장 긴 이름을 기준으로 그린다.")
    @Test
    void drawLadderTest() {
        OutputView outputView = new OutputView(playerNames, ladder);

        String drawResult = outputView.parseLadder();

        assertThat(drawResult).isEqualTo("     |-----|\n" +
                "     |-----|\n" +
                "     |-----|\n" +
                "     |-----|\n" +
                "     |-----|\n");
    }

    @DisplayName("이름 길이에 따라 공백을 조절해서 게임 참여자 명단을 그릴 수 있다.")
    @Test
    void drawPlayerNames() {
        OutputView outputView = new OutputView(playerNames, ladder);

        String drawResult = outputView.parsePlayerNames();

        assertThat(drawResult).isEqualTo(" poppo   ita");
    }
}

package nextstep.ladder.ui;

import nextstep.ladder.domain.ladder.*;
import nextstep.ladder.domain.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderOutputViewTests {
    private PointAddStrategy simplePointAddStrategy;
    private Players players;
    private Ladder ladder;

    @BeforeEach
    public void setup() {
        simplePointAddStrategy = new SimplePointAddStrategy();
        players = Players.create(Arrays.asList("poppo", "ita"));
        int maxLadderHeight = 5;
        ladder = Ladder.create(maxLadderHeight, players.size(), simplePointAddStrategy);
    }

    @DisplayName("PlayerNames, Ladder 객체를 주입받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        LadderOutputView ladderOutputView = new LadderOutputView(players, ladder);

        assertThat(ladderOutputView).isNotNull();
    }

    @DisplayName("Line 한 줄을 출력할 수 있다. 이때 사다리의 폭은 현재 이름 중 가장 긴 이름을 기준으로 그린다.")
    @Test
    void drawLineTest() {
        LadderOutputView ladderOutputView = new LadderOutputView(players, ladder);

        Line line = LineFactory.create(players.size(), simplePointAddStrategy);
        assertThat(line.size()).isEqualTo(2);

        String drawResult = ladderOutputView.parseLine(line);

        assertThat(drawResult).isEqualTo("     |-----|");
    }

    @DisplayName("Ladder 전체를 출력할 수 있다. 이때 사다리의 폭은 현재 이름 중 가장 긴 이름을 기준으로 그린다.")
    @Test
    void drawLadderTest() {
        LadderOutputView ladderOutputView = new LadderOutputView(players, ladder);

        String drawResult = ladderOutputView.parseLadder();

        assertThat(drawResult).isEqualTo("     |-----|\n" +
                "     |-----|\n" +
                "     |-----|\n" +
                "     |-----|\n" +
                "     |-----|");
    }

    @DisplayName("이름 길이에 따라 공백을 조절해서 게임 참여자 명단을 그릴 수 있다.")
    @Test
    void drawPlayerNames() {
        LadderOutputView ladderOutputView = new LadderOutputView(players, ladder);

        String drawResult = ladderOutputView.parsePlayerNames();

        assertThat(drawResult).isEqualTo(" poppo   ita");
    }
}

package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LadderGame;
import nextstep.ladder.model.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameTest {
    @Test
    @DisplayName("ladder game 생성 테스트")
    void createLadderGameTest() {
        //given
        List<String> testNames = new ArrayList<>(List.of("pobi", "honux", "crong", "jk"));
        int testHeight = 5;

        //when
        LadderGame ladderGame = new LadderGame(testNames, testHeight);

        //then
        Assertions.assertThat(ladderGame).isNotNull();
        Assertions.assertThat(ladderGame.getPlayers()).hasSize(4);
        Assertions.assertThat(ladderGame.getPlayers().stream()
                        .map(it -> it.getName())
                        .collect(Collectors.toList()))
                .hasSameElementsAs(testNames);
        Assertions.assertThat(ladderGame.getHeight()).isEqualTo(testHeight);
    }

    @Test
    @DisplayName("ladder game 실행 테스트")
    void runLadderGameTest() {
        //given
        List<String> testNames = new ArrayList<>(List.of("pobi", "honux", "crong", "jk"));
        int testHeight = 5;
        MockLineGenerator lineGenerator = new MockLineGenerator();

        LadderGame ladderGame = new LadderGame(testNames, testHeight);

        //when
        Ladder ladder = ladderGame.run(lineGenerator);

        //then
        Assertions.assertThat(ladder.getLines().size()).isEqualTo(testHeight);
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            List<Boolean> points = line.getPoints();
            Assertions.assertThat(points).hasSize(testNames.size() - 1);
        }
    }
}

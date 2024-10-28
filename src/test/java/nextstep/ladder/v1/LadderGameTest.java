package nextstep.ladder.v1;

import nextstep.ladder.v1.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameTest {
    @Test
    @DisplayName("ladder game 생성 테스트")
    void createLadderGameTest() {
        //given
        List<String> testNames = new ArrayList<>(List.of("pobi", "honux", "crong", "jk"));

        //when
        LadderGame ladderGame = new LadderGame(testNames);

        //then
        Assertions.assertThat(ladderGame).isNotNull();
        Assertions.assertThat(ladderGame.getPlayers()).hasSize(4);
        Assertions.assertThat(ladderGame.getPlayers().stream()
                        .map(it -> it.getName())
                        .collect(Collectors.toList()))
                .hasSameElementsAs(testNames);
    }

    @Test
    @DisplayName("ladder game 사다리 생성 테스트")
    void makeLadderTest() {
        //given
        List<String> testNames = new ArrayList<>(List.of("pobi", "honux", "crong", "jk"));
        int testHeight = 5;
        MockLineGenerator lineGenerator = new MockLineGenerator();

        LadderGame ladderGame = new LadderGame(testNames);

        //when
        Ladder ladder = ladderGame.makeLadder(testHeight, lineGenerator);

        //then
        Assertions.assertThat(ladder.getLines().size()).isEqualTo(testHeight);
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            List<Boolean> points = line.getPoints().stream().map(Point::getValue).collect(Collectors.toList());
            Assertions.assertThat(points).hasSize(testNames.size() - 1);
        }
    }

    @Test
    @DisplayName("사다리 게임 결과")
    void makeLadderResultTest() {
        //given
        List<String> testNames = new ArrayList<>(List.of("pobi", "honux", "crong", "jk"));
        int testHeight = 5;
        MockLineGenerator lineGenerator = new MockLineGenerator();

        LadderGame ladderGame = new LadderGame(testNames);

        Ladder ladder = ladderGame.makeLadder(testHeight, lineGenerator);

        List<Prize> prizes = List.of(new Prize("꽝"), new Prize("5000"), new Prize("꽝"), new Prize("3000"));

        //when
        LadderResult ladderResult = ladderGame.makeLadderResult(prizes);

        //then
        LinkedHashMap<Player, Prize> result = ladderResult.getAllResult();
        Assertions.assertThat(result).hasSize(4);
        Assertions.assertThat(result.get(new Player("pobi"))).isEqualTo(new Prize("5000"));
        Assertions.assertThat(result.get(new Player("honux"))).isEqualTo(new Prize("꽝"));
        Assertions.assertThat(result.get(new Player("crong"))).isEqualTo(new Prize("3000"));
        Assertions.assertThat(result.get(new Player("jk"))).isEqualTo(new Prize("꽝"));
    }
}

package nextstep.ladder.v2;

import nextstep.ladder.v2.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderGameTest {
    @Test
    @DisplayName("ladder game class 생성")
    void createLadderGameTest() {
        //given
        List<String> names = List.of("pobi", "honux", "crong", "jk");
        Ladder ladder = Ladder.of(names.size()).createLadder(1, new MockPointGenerator());
        PlayerGroup group = new PlayerGroup(names);

        //when
        LadderGame game = new LadderGame(names, ladder);

        //then
        Assertions.assertThat(game).isNotNull();
        Assertions.assertThat(game.getPlayerGroup().getSize()).isEqualTo(names.size());
        Assertions.assertThat(game.getPlayerGroup()).isEqualTo(group);
    }


    @Test
    @DisplayName("ladder game - ladder result 생성")
    void createLadderResultWithLadderGameTest() {
        //given
        List<String> names = List.of("pobi", "honux", "crong");
        PointGenerator pointGenerator = new MockPointGenerator();
        int height = 1;

        Ladder ladder = Ladder.of(names.size()).createLadder(height, pointGenerator);

        LadderGame game = new LadderGame(names, ladder);

        List<String> prizeInput = List.of("꽝", "5000", "꽝");

        //when
        LadderResult ladderResult = game.createLadderResult(prizeInput);

        //then
        // false true false false
        List<Point> expectedPoints = List.of(new Point(false, true), new Point(true, false), new Point(false, false));
        Assertions.assertThat(ladder.getLines().get(0).getPoints()).hasSameElementsAs(expectedPoints);

        List<Prize> expectedPrizes = List.of(new Prize("꽝"), new Prize("5000"), new Prize("꽝"));
        Assertions.assertThat(ladderResult.getResultByPlayer(new Player("pobi")).get(new Player("pobi"))).isEqualTo(expectedPrizes.get(1));
    }
}

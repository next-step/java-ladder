package ladder.domain;

import ladder.domain.strategy.CoordinateGenerator;
import ladder.domain.strategy.ManualCoordinateGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameResultTest {

    private static final CoordinateGenerator COORDINATE_GENERATION = new ManualCoordinateGenerator();

    @Test
    @DisplayName("첫번째 사용자의 결과가 맞는지 확인")
    void 사다리게임_결과확인() {
        People people = new People(new ArrayList<>(Arrays.asList("a", "b", "c", "d")));
        Height heightCount = new Height(5);
        LadderLines ladderLines = LadderLines.of(people, heightCount, COORDINATE_GENERATION);
        Gifts gifts = new Gifts(new ArrayList<>(Arrays.asList("1", "2", "3", "4")), people);

        GameResult gameResult = GameResult.valueOf(people,ladderLines,gifts);

        assertThat(gameResult.checkResult(new Name("a"))).isEqualTo(new Gift("2"));

    }

}

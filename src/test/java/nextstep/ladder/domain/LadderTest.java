package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LinePoints;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.PlayerPrizes;
import nextstep.ladder.domain.point.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @DisplayName("높이만큼의 라인들을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void line_height(int height) {
        Ladder ladder = createLadder(height, 2);
        assertThat(ladder.getLines()).hasSize(height);
    }

    @DisplayName("높이는 최소 1이상이다. 1미만시 예외 발생")
    @Test
    void min_height() {
        assertThatThrownBy(() -> createLadder(0, 2))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저는 2명 이상이다. 2명 미만시 예외 발생")
    @Test
    void min_player() {
        assertThatThrownBy(() -> createLadder(4, 1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private Ladder createLadder(int height, int playerCount) {
        List<Line> lines = Stream.generate(() -> new Line(
            LinePoints.of(playerCount, new RandomPointGenerator())))
            .limit(height)
            .collect(Collectors.toList());

        return new Ladder(lines, playerCount);
    }


    @DisplayName("모든 유저의 사디리 결과를 확인한다.")
    @Test
    void all_result() {
        List<Line> lines = Stream.generate(
            () -> new Line(LinePoints.of(3, () -> false)))
            .limit(5)
            .collect(Collectors.toList());

        List<Player> players = Arrays
            .asList(new Player("user1"), new Player("user2"), new Player("user3"));
        List<String> prize = Arrays.asList("꽝", "상품1", "상품2");
        Ladder ladder = new Ladder(lines, 3);

        Map<Player, String> expect = new LinkedHashMap<>();
        expect.put(new Player("user1"), "꽝");
        expect.put(new Player("user2"), "상품1");
        expect.put(new Player("user3"), "상품2");

        assertThat(ladder.play(players, prize)).isEqualTo(new PlayerPrizes(expect));
    }
}

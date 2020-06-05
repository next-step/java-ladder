package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LinePoints;
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

        return new Ladder(lines, getPlayer(playerCount));
    }

    private List<Player> getPlayer(int count) {
        return Stream.generate(() -> UUID.randomUUID().toString().substring(0, 5))
            .limit(count)
            .map(Player::of)
            .collect(Collectors.toList());
    }

    @DisplayName("한명의 유저의 결과를 확인한다.")
    @Test
    void single_result() {
        List<Line> lines = Stream.generate(() -> new Line(
            LinePoints.of(2, () -> false)))
            .limit(5)
            .collect(Collectors.toList());
        ;

        Ladder ladder = new Ladder(
            lines,
            Arrays.asList(Player.of("user1"), Player.of("user2")),
            Arrays.asList("꽝", "상품1")
        );

        assertThat(ladder.play(Player.of("user1"))).isEqualTo("꽝");
        assertThat(ladder.play(Player.of("user2"))).isEqualTo("상품1");
    }
}

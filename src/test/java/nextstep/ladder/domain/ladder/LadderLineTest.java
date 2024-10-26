package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.direction.Direction;
import nextstep.ladder.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static nextstep.ladder.domain.direction.Direction.LEFT_DOWN;
import static nextstep.ladder.domain.direction.Direction.RIGHT_DOWN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderLineTest {

    @Test
    void create() {
        LadderLine ladderLine = LadderLine.of(9);

        assertThat(ladderLine.copy().size()).isEqualTo(8);
    }

    @Test
    void throwExceptionIfPlayerCountNotMatch() {
        LadderLine ladderLine = new LadderLine(List.of(RIGHT_DOWN, LEFT_DOWN, RIGHT_DOWN, LEFT_DOWN, RIGHT_DOWN, LEFT_DOWN));
        List<Player> players = IntStream.range(0, 7)
                .mapToObj(i -> new Player(String.valueOf(i), i))
                .collect(Collectors.toList());

        assertThatIllegalArgumentException().isThrownBy(() -> ladderLine.play(players));
    }

    @ParameterizedTest
    @DisplayName("이전 결과 리스트를 받아 사다리 게임 한 층을 진행 시킨 결과 반영시킨다")
    @CsvSource(value = {
            "RIGHT_DOWN, LEFT_DOWN, RIGHT_DOWN, LEFT_DOWN, RIGHT_DOWN, LEFT_DOWN:1,0,3,2,5,4",
            "RIGHT_DOWN, LEFT_DOWN, DOWN, RIGHT_DOWN, LEFT_DOWN, DOWN:1,0,2,4,3,5"
    }, delimiter = ':')
    void applyLadderPlayResultToPlayerGroup(String line, String result) {
        LadderLine ladderLine = new LadderLine(toDirections(line));
        List<Player> players = IntStream.range(0, 6)
                        .mapToObj(i -> new Player(String.valueOf(i), i))
                        .collect(Collectors.toList());
        List<Player> finished = toPlayerGroup(result);

        for (int i = 0; i < players.size(); i++) {
            ladderLine.play(players.get(i));
            assertThat(players.get(i).getPosition()).isEqualTo(finished.get(i).getPosition());
        }
    }

    public static List<Direction> toDirections(String directions) {
        return Stream.of(directions.split(","))
                .map(String::trim)
                .map(Direction::valueOf)
                .collect(Collectors.toList());
    }

    private List<Player> toPlayerGroup(String string) {
        String[] positions = string.split(",");

        return IntStream.range(0, 6)
                .mapToObj(i -> new Player(String.valueOf(i), Integer.parseInt(positions[i])))
                .collect(Collectors.toList());
    }
}

package ladder.domain;

import ladder.domain.exception.NotEnoughPlayerToPlayException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerGroupTest {

    @DisplayName("생성할 때")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class Create {

        @DisplayName("주어진 이름들로 플레이어가 생성되고, 생성되는 순서에 따라 x좌표가 1씩 증가한다.")
        @Test
        void from() {
            List<String> nameValues = List.of("apple", "foby");
            List<Player> players = List.of(new Player("apple", 0, 0), new Player("foby", 1, 0));
            PlayerGroup expected = new PlayerGroup(players);

            PlayerGroup actual = PlayerGroup.from(nameValues);

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("2명 미만의 플레이어이면 예외가 발생한다.")
        @ParameterizedTest
        @MethodSource("generateNotEnoughPlayers")
        void validate_number_of_player(List<Player> players) {
            assertThatThrownBy(() -> new PlayerGroup(players))
                    .isExactlyInstanceOf(NotEnoughPlayerToPlayException.class)
                    .hasMessage("플레이어가 충분하지 않습니다. 최소인원 : 2");
        }

        private Stream<List<Player>> generateNotEnoughPlayers() {
            return Stream.of(
                    null,
                    new ArrayList<>(),
                    List.of(new Player("apple", 0, 0))
            );
        }
    }
}
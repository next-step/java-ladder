package ladder.domain;

import ladder.domain.exception.DuplicateNameException;
import ladder.domain.exception.NotEnoughPlayerToPlayException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
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

        @DisplayName("중복되는 이름이 존재하면 예외가 발생한다.")
        @Test
        void validate_duplicate_name() {
            List<String> names = List.of("apple", "foby", "apple");

            assertThatThrownBy(() -> PlayerGroup.from(names))
                    .isExactlyInstanceOf(DuplicateNameException.class)
                    .hasMessage("중복되는 이름은 사용할 수 없습니다.");
        }
    }

    @DisplayName("라인 수를 반환한다.")
    @Test
    void find_number_of_player() {
        NumberOfLine expected = new NumberOfLine(2);
        PlayerGroup playerGroup = PlayerGroup.from(List.of("apple", "foby", "jung"));

        NumberOfLine actual = playerGroup.findNumberOfPlayer();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("이름들을 가져온다.")
    @Test
    void find_names() {
        List<Name> expected = List.of(new Name("apple"), new Name("foby"), new Name("jung"));
        PlayerGroup playerGroup = PlayerGroup.from(List.of("apple", "foby", "jung"));

        List<Name> actual = playerGroup.findNames();

        assertThat(actual).isEqualTo(expected);
    }
}

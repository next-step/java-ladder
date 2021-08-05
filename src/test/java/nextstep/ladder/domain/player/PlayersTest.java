package nextstep.ladder.domain.player;

import nextstep.ladder.domain.play.PlayerPosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayersTest {

    @DisplayName("플레이어즈 그룹은 이름 리스트를 가지고 객체를 생성한다")
    @Test
    void should_make_players() {
        //arrange, act, assert
        assertThat(Players.of(Arrays.asList("a", "bb", "ccc"))).isInstanceOf(Players.class);
    }

    @DisplayName("name 리스트가 null이거나 빈값일경우 경우 IllegalArgumentException을 발생시킨다")
    @NullAndEmptySource
    @ParameterizedTest
    void should_throw_exception(List<String> name) {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> Players.of(name));
    }

    @DisplayName("플레이어 이름을 반환한다")
    @Test
    void should_return_players_name() {
        //arrange
        Players players = Players.of(Arrays.asList("a", "bb", "ccc"));

        //act
        List<String> names = players.getNames();

        //assert
        assertThat(names).containsExactly("a", "bb", "ccc");
    }

    @DisplayName("플레이어 count를 반환한다")
    @Test
    void should_return_players_count() {
        //arrange
        Players players = Players.of(Arrays.asList("a", "bb", "ccc"));

        //act
        int count = players.count();

        //assert
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("플레이어 name을 position에 맞게 반환한다")
    @Test
    void should_return_players_name_at_position() {
        //arrange
        Players players = Players.of(Arrays.asList("a", "bb", "ccc"));
        PlayerPosition playerPosition = PlayerPosition.of(0);

        //act
        String name = players.getNameAt(playerPosition);

        //assert
        assertThat(name).isEqualTo("a");
    }
}

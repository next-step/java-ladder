package ladder.domain;

import ladder.exception.PlayerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @DisplayName("Players 생성")
    @Test
    public void constructor_success() throws Exception {
        //then
        Players players = new Players(
                Arrays.asList(new Player("a"), new Player("B")));
    }

    @DisplayName("2명 미만의 Players 생성")
    @Test
    public void constructor_fail() throws Exception {
        //then
        assertThatThrownBy(
                () -> new Players(Arrays.asList(new Player("a")))
        ).isInstanceOf(PlayerException.class);
    }

    @DisplayName("Player의 수를 반환한다")
    @Test
    public void getPlayersCount_success() throws Exception {
        //given
        Players players = new Players(
                Arrays.asList(new Player("a"), new Player("B")));

        //then
        assertThat(players.size()).isEqualTo(2);
    }

    @DisplayName("이름 List<String> 을 이용하여 Players를 생성")
    @Test
    public void of_success() throws Exception {
        //given
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");

        //when
        Players players = Players.of(names);

        //then
        assertThat(players.size()).isEqualTo(3);
    }

    @DisplayName("참가자를 찾고 index를 찾는다")
    @Test
    public void findPlayer_success() throws Exception {
        //given
        Players players = Players.of(Arrays.asList("a", "b", "c", "d"));

        //when
        int a = players.findPlayer("a");
        int b = players.findPlayer("b");
        int c = players.findPlayer("c");
        int d = players.findPlayer("d");

        //then
        assertThat(a).isEqualTo(0);
        assertThat(b).isEqualTo(1);
        assertThat(c).isEqualTo(2);
        assertThat(d).isEqualTo(3);
    }

    @DisplayName("참가자를 찾을 수 없을 경우 exception")
    @Test
    public void findPlayer_fail() throws Exception {
        //given
        Players players = Players.of(Arrays.asList("a", "b", "c", "d"));

        //then
        assertThatThrownBy(
                () -> players.findPlayer("ABC")
        ).isInstanceOf(PlayerException.class);

    }

    @DisplayName("동일 이름의 참가자가 등록 될 수 없다")
    @Test
    public void validateDuplicatePlayer_fail() throws Exception {
        //then
        assertThatThrownBy(
                () -> Players.of(Arrays.asList("a", "a", "b"))
        ).isInstanceOf(PlayerException.class);
    }
}

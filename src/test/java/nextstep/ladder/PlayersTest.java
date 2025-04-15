package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {

    @Test
    void testEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Players.of(new String[0]));
    }

    @Test
    void contains() {
        Players players = Players.of(new String[]{"a", "b", "c"});
        assertThat(players.contains(new Name("a"))).isTrue();
        assertThat(players.notContains(new Name("d"))).isTrue();
    }

    @Test
    void getWithPosition() {
        Players players = Players.of(new String[]{"a", "b", "c"});
        Entry entry = players.get(new Position(0, 0));
        assertThat(entry.toString()).isEqualTo("a");
    }

    @Test
    void getWithValue() {
        Players players = Players.of(new String[]{"a", "b", "c"});
        Entry entry = players.get(new Name("a"));
        assertThat(entry).isEqualTo(new Entry("a", new Position(0, 0)));
    }

    @Test
    void getSamePosition() {
        Players players = Players.of(new String[]{"a", "b", "c"});
        Entry entry = players.getSamePosition(new Entry("aRes", new Position(0, 0)));
        assertThat(entry).isEqualTo(new Entry("a", new Position(0, 0)));
    }
}

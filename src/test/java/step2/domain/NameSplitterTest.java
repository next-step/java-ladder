package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NameSplitterTest {

    @Test
    @DisplayName("이름이 잘 나누어지는지 확인한다.")
    void create() {
        //given
        String name = "a,b,c";
        List<Player> players = NameSplitter.splitParticipationNames(name);

        //then
        assertThat(players).isEqualTo(Arrays.asList(new Player("a"), new Player("b"), new Player("c")));
        assertThat(players).containsExactly(new Player("a"), new Player("b"), new Player("c"));
    }
}

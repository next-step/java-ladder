package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @Test
    void create() {
        String input = "jin,jolly,wuga";
        List<String> inputPlayers = Stream.of(input.split(",")).collect(Collectors.toList());
        Players players = new Players(inputPlayers);

        assertThat(players.getPlayers().size()).isEqualTo(3);
    }
}

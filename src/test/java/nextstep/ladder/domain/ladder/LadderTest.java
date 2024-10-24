package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void create() {
        Ladder ladder = Ladder.of(5, 4);

        assertThat(ladder.ladderLines().size()).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "true,false,true,false:true,false,true,false:true,false,false,true:true,false,false,true:0,1,2,3,4",
            "true,false,true,false:true,false,false,true:true,false,true,false:true,false,false,true:0,1,4,2,3"
    }, delimiter = ':')
    void apply_ladder_result_to_list_from_play_result_of_all_ladder_lines(
            String ladderLine1,
            String ladderLine2,
            String ladderLine3,
            String ladderLine4,
            String result
    ) {
        Ladder ladder = new Ladder(List.of(
                toLadderLine(ladderLine1),
                toLadderLine(ladderLine2),
                toLadderLine(ladderLine3),
                toLadderLine(ladderLine4)));

        List<Player> players = toPlayers();
        ladder.play(players);

        assertThat(players).containsExactly(toPlayerArray(result));
    }

    private static List<Player> toPlayers() {
        return IntStream.range(0, 5)
                .mapToObj(i -> new Player(String.valueOf(i), i))
                .collect(Collectors.toList());
    }

    private Player[] toPlayerArray(String text) {
        String[] positions = text.split(",");

        return IntStream.range(0, 5)
                .mapToObj(i -> new Player(String.valueOf(i), Integer.parseInt(positions[i])))
                .toArray(Player[]::new);
    }

    private LadderLine toLadderLine(String text) {
        return new LadderLine(toBooleanList(text));
    }

    private List<Boolean> toBooleanList(String text) {
        return Stream.of(text.split(",")).map(Boolean::parseBoolean).collect(Collectors.toList());
    }
}

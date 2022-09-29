package ladder.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFactoryTest {
    private List<Player> playerNames;
    private List<PartLine> partLines;
    private List<Line> lines;
    
    @BeforeEach
    void setUp() {
        playerNames = Arrays.asList(new Player(new PlayerName("pobi")), new Player(new PlayerName("honux")), new Player(new PlayerName("jun")), new Player(new PlayerName("crong")));
        ;
        partLines = IntStream.range(0, playerNames.size())
                .mapToObj(count -> new PartLine(false))
                .collect(Collectors.toList());
        lines = IntStream.range(0, 5)
                .mapToObj(count -> new Line(partLines))
                .collect(Collectors.toList());
    }
    
    @Test
    @DisplayName("사다리 생성")
    void createLadder() {
        Ladder ladder = LadderFactory.of(new Players(playerNames), 5, countOfPlayers -> partLines);
        assertThat(ladder).isEqualTo(new Ladder(lines));
    }
}
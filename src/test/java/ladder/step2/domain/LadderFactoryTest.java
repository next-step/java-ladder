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
    private PartLine falsePartLine;
    
    @BeforeEach
    void setUp() {
        playerNames = Arrays.asList(new Player("pobi"), new Player("honux"), new Player("jun"), new Player("crong"));
        falsePartLine = new PartLine(false);
        partLines = IntStream.range(0, playerNames.size()).mapToObj(count -> falsePartLine).collect(Collectors.toList());
    }
    
    @Test
    @DisplayName("사다리 생성")
    void createLadder() {
        Ladder ladder = LadderFactory.of(playerNames, 5, countOfPlayers -> partLines);
        List<Line> lines = IntStream.range(0, 5)
                .mapToObj(count -> new Line(partLines))
                .collect(Collectors.toList());
        assertThat(ladder).isEqualTo(new Ladder(lines));
    }
}
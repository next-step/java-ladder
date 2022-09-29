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
    private List<String> playerNames;
    private PartLine falsePartLine;
    
    @BeforeEach
    void setUp() {
        playerNames = new ArrayList<>(Arrays.asList("pobi", "honux", "jun", "crong"));
        falsePartLine = new PartLine(false);
    }
    
    @Test
    @DisplayName("사다리 생성")
    void createLadder() {
        Ladder ladder = LadderFactory.of(playerNames, 5, (partLines, countOfPlayers) -> partLines.add(falsePartLine));
        List<Line> lines = IntStream.range(0, 5)
                .mapToObj(count -> new Line(playerNames.size(), (partLines, countOfPlayers) -> partLines.add(falsePartLine)))
                .collect(Collectors.toList());
        assertThat(ladder).isEqualTo(new Ladder(lines));
    }
}
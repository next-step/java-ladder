package nextstep.ladder.ladder;

import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LinesOfOneHeight;
import nextstep.ladder.entity.ladder.NoneDrawRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    LinesOfOneHeight firstLines;
    LinesOfOneHeight secondLines;
    LinesOfOneHeight threeLines;
    LinesOfOneHeight fourthLines;
    LinesOfOneHeight fifthLines;
    Ladder ladder;

    @BeforeEach
    public void setup(){
        firstLines = new LinesOfOneHeight(5, () -> true);
        secondLines = new LinesOfOneHeight(5, new NoneDrawRule());
        threeLines = new LinesOfOneHeight(5, () -> true);
        fourthLines = new LinesOfOneHeight(5, new NoneDrawRule());
        fifthLines = new LinesOfOneHeight(5, () -> true);

        List<LinesOfOneHeight> linesOfOneHeights= new ArrayList<>();
        linesOfOneHeights.add(firstLines);
        linesOfOneHeights.add(secondLines);
        linesOfOneHeights.add(threeLines);
        linesOfOneHeights.add(fourthLines);
        linesOfOneHeights.add(fifthLines);

        ladder = new Ladder(linesOfOneHeights);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2", "4,4"})
    @DisplayName("게임 종료 후 참여자 위치")
    public void gameEndPosition(int startPosition, int gameEndPosition) {
        assertThat(ladder.gameEndPosition(startPosition)).isEqualTo(gameEndPosition);
    }
}

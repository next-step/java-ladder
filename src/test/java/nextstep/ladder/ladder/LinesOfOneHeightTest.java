package nextstep.ladder.ladder;

import nextstep.ladder.entity.draw.AlwaysDrawRule;
import nextstep.ladder.entity.ladder.Direction;
import nextstep.ladder.entity.ladder.NoneDrawRule;
import nextstep.ladder.entity.ladder.LinesOfOneHeight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesOfOneHeightTest {

    LinesOfOneHeight firstLines;
    LinesOfOneHeight secondLines;

    @BeforeEach
    public void setup(){
        firstLines = new LinesOfOneHeight(5, new AlwaysDrawRule());
        secondLines = new LinesOfOneHeight(5, new NoneDrawRule());
    }

    @ParameterizedTest
    @CsvSource(value = {"0:RIGHT", "1:LEFT", "2:RIGHT", "3:LEFT", "4:NONE"}, delimiter = ':')
    @DisplayName("사다리 게임 조건 하에 무조건 그리기")
    public void alwaysDrawLine(int value, Direction expectedDirection){
        assertThat(firstLines.positionLine(value).lineDirection()).isEqualTo(expectedDirection);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:NONE", "1:NONE", "2:NONE", "3:NONE", "4:NONE"}, delimiter = ':')
    @DisplayName("라인 안 그리기")
    public void noneDrawLine(int value, Direction expectedDirection){
        assertThat(secondLines.positionLine(value).lineDirection()).isEqualTo(expectedDirection);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:4"}, delimiter = ':')
    @DisplayName("다음 높이의 참여자 위치")
    public void nextHeightPosition(int currentPosition, int nextHeightPosition){
        assertThat(firstLines.nextHeightPosition(currentPosition)).isEqualTo(nextHeightPosition);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2", "3:3", "4:4"}, delimiter = ':')
    @DisplayName("다음 높이의 참여자 위치가 같을 때")
    public void nextHeightSamePosition(int currentPosition, int nextHeightPosition){
        assertThat(secondLines.nextHeightPosition(currentPosition)).isEqualTo(nextHeightPosition);
    }
}

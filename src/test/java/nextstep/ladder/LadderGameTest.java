package nextstep.ladder;

import nextstep.ladder.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {
    Lines firstLine;
    Lines secondLine;

    @BeforeEach
    public void setup(){
        firstLine = new Lines(5, new AlwaysDrawRule());
        secondLine = new Lines(5, new LastPointNoneDrawRule());
    }

    @Test
    @DisplayName("이름 길이 제한")
    public void nameLength(){
        assertThatIllegalArgumentException()
            .isThrownBy(() ->
                new User("nameLengthOver")
            );
    }

    @ParameterizedTest
    @CsvSource(value = {"0:RIGHT", "1:LEFT", "2:RIGHT", "3:LEFT", "4:NONE"}, delimiter = ':')
    @DisplayName("사다리 게임 조건 하에 무조건 그리기")
    public void alwaysDrawLine(int value, Direction expectedDirection){
        assertThat(firstLine.positionLine(value).getLineDirection()).isEqualTo(expectedDirection);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:NONE", "1:NONE", "2:NONE", "3:NONE", "4:NONE"}, delimiter = ':')
    @DisplayName("라인 안 그리기")
    public void noneDrawLine(int value, Direction expectedDirection){
        assertThat(secondLine.positionLine(value).getLineDirection()).isEqualTo(expectedDirection);
    }
}

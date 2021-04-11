package nextstep.ladder;

import nextstep.ladder.entity.Line;
import nextstep.ladder.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {
    Line firstLine;
    Line secondLine;

    @BeforeEach
    public void setup(){
        firstLine = new Line(0, 5);
        secondLine = new Line(1, 5);
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
    @CsvSource(value = {"0:true", "1:false", "2:true", "3:false", "4:true"}, delimiter = ':')
    @DisplayName("사다리 홀수 라인")
    public void oddLineInit(int value, boolean expected){
        assertThat(firstLine.getPointIndex(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true", "2:false", "3:true", "4:false"}, delimiter = ':')
    @DisplayName("사다리 짝수 라인")
    public void evenLineInit(int value, boolean expected){
        assertThat(secondLine.getPointIndex(value)).isEqualTo(expected);
    }
}

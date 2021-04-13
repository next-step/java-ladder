package nextstep.ladder;

import nextstep.ladder.entity.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("지점에서 오른쪽 방향으로 가는 라인")
    public void rightDirectionLine(){
        Line rightDirectionLine = new Line(Direction.NONE, new AlwaysDrawRule());
        assertThat(rightDirectionLine.getLineDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("오른쪽 방향으로 가는 라인 다음 지점은 무조건 왼쪽으로 가는 라인")
    public void leftDirectionLine(){
        Line rightDirectionLine = new Line(Direction.RIGHT, new RandomDrawRule());
        assertThat(rightDirectionLine.getLineDirection()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("마지막 지점에서는 오른쪽으로 가는 라인이 없어야함")
    @ParameterizedTest
    @CsvSource(value = {"RIGHT:LEFT", "LEFT:NONE", "NONE:NONE"}, delimiter = ':')
    public void lastPointLine(Direction direction, Direction expectedNextDirection){
        assertThat(new Line(direction, new LastPointNoneDrawRule()).getLineDirection()).isEqualTo(expectedNextDirection);
    }
}

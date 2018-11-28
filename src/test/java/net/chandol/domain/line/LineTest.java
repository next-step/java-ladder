package net.chandol.domain.line;

import net.chandol.domain.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LineTest {

    @Test
    public void 왼쪽패딩값_이름길이_홀수() {
        Line line = new Line(0, new Player("names"), null);
        Assertions.assertThat(line.leftPaddingSize()).isEqualTo(2);
    }

    @Test
    public void 왼쪽패딩값_이름길이_짝수() {
        Line line = new Line(0, new Player("name"), null);
        Assertions.assertThat(line.leftPaddingSize()).isEqualTo(2);
    }

    @Test
    public void 오른쪽패딩값_이름길이_홀수() {
        Line line = new Line(0, new Player("names"), null);
        Assertions.assertThat(line.rightPaddingSize()).isEqualTo(2);
    }

    @Test
    public void 오른쪽패딩값_이름길이_짝수() {
        Line line = new Line(0, new Player("name"), null);
        Assertions.assertThat(line.rightPaddingSize()).isEqualTo(1);
    }
}
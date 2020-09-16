package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("line 생성 테스트")
    public void createLineTest(){
        Line line = Line.of(5);

       assertThat(line.getLine().size()).isEqualTo(4); // line이 N개일 경우, 움직일 수 있는 point의 갯수는 N-1(맨 마지막 point는 STOP 상태로 고정)
    }
}
package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
//        List<Point> point = new ArrayList<>();
//        for(int i=0; i<sizeOfPerson; i++){
//            point.add(new Point(i, new Direction()));
//        }
//        assertThat(LadderLine.init(sizeOfPerson))
//                .isEqualTo(new LadderLine( ));
//        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @DisplayName("player 수가 2명일 때, init 은 모두 false 인 경우 이므로 position 이 0으로 나온다.")
    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        assertThat(line.move(0)).isEqualTo(0);
    }

}
package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 플레이어_수_만큼_포인트를_랜덤으로_생성한다() {
        int numberOfPlayers = 5;
        Line line = Line.from(numberOfPlayers);

        assertThat(line.getPoints().size()).isEqualTo(numberOfPlayers);
    }

//    @Test
//    void 플레이어의_위치와_Bar의_위치가_같으면_플레이어의_위치를_1만큼_증가시킨다() {
//        Line line = new Line(Arrays.asList(Bar.from(false), Bar.from(true), Bar.from(false)));
//
//        int currentPosition = 1;
//        Position playerPosition = Position.from(currentPosition);
//
//        assertThat(line.travel(playerPosition).getPosition())
//                .isEqualTo(currentPosition + 1);
//    }
//
//    @Test
//    void 플레이어의_위치보다_Bar의_위치가_1만큼_작으면_플레이어의_위치를_1만큼_감소시킨다() {
//        Line line = new Line(Arrays.asList(Bar.from(false), Bar.from(true), Bar.from(false)));
//
//        int currentPosition = 2;
//        Position playerPosition = Position.from(currentPosition);
//
//        assertThat(line.travel(playerPosition).getPosition())
//                .isEqualTo(currentPosition - 1);
//    }
//
//    @Test
//    void 플레이어의_위치보다_Bar의_위치가_1만큼_크면_플레이어의_위치는_바뀌지_않는다() {
//        Line line = new Line(Arrays.asList(Bar.from(false), Bar.from(true), Bar.from(false)));
//
//        int currentPosition = 0;
//        Position playerPosition = Position.from(currentPosition);
//
//        assertThat(line.travel(playerPosition).getPosition())
//                .isEqualTo(currentPosition);
//    }
//
//    @Test
//    void 플레이어의_위치와_Bar의_위치가_2이상_차이나면_플레이어의_위치는_바뀌지_않는다() {
//        Line line = new Line(Arrays.asList(Bar.from(true), Bar.from(false), Bar.from(false)));
//
//        int currentPosition = 2;
//        Position playerPosition = Position.from(currentPosition);
//
//        assertThat(line.travel(playerPosition).getPosition())
//                .isEqualTo(currentPosition);
//    }

}

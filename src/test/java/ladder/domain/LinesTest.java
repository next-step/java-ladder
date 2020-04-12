package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @DisplayName("참가자 수 만큼 Node를 가진, 높이 만큼의 Line를 가지도록 생성한다.")
    @Test
    public void of_success() throws Exception {
        //given
        Lines lines = Lines.of(5, 3);

        //then
        assertThat(lines.getLines().size()).isEqualTo(3);
        assertThat(lines.getLines().get(0).getNodes().getNodes().size()).isEqualTo(5);
    }

    @DisplayName("사다리 이동 결과 확인")
    @Test
    public void move() throws Exception {
        //given
        Lines lines = new Lines(
                Arrays.asList(
                        new Line(new Nodes(Arrays.asList(
                                new Node(0, new Way(false, true)),
                                new Node(1, new Way(true, false)))
                        )),
                        new Line(new Nodes(Arrays.asList(
                                new Node(0, new Way(false, true)),
                                new Node(1, new Way(true, false)))
                        ))));

        //when
        Node move1 = lines.move(0);
        Node move2 = lines.move(1);

        //then
        assertThat(move1.getIndex()).isEqualTo(0);
        assertThat(move2.getIndex()).isEqualTo(1);
    }
}

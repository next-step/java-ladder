package game.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/10.
 */
class LineTest {

    @DisplayName("라인 생성")
    @Test
    void constructor() {

        // given
        int countOfPlayer = 5;

        // when
        Line line = new Line(countOfPlayer);
        System.out.println(line);

        // then
        assertThat(line).isNotNull();

    }

    @DisplayName("라인 생성")
    @Test
    void getPoints() {

        // given
        int countOfPlayer = 5;

        // when
        Line line = new Line(countOfPlayer);
        System.out.println(line);

        // then
        assertThat(line.getPoints()).hasSize(countOfPlayer);
    }
}
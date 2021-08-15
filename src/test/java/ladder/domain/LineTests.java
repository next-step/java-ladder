package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTests {

    @DisplayName("Line 생성 테스트")
    @Test
    void create(){
        Line line = Line.of(4);

        assertThat(line).isEqualTo(Line.of(4));
    }

    @DisplayName("Line 생성될 때 인접한 상태값은 달라야 함")
    @Test
    void trueFalseTest(){
        Line line = Line.of(4);

        System.out.println(line.isDraw(1));
        System.out.println(line.isDraw(2));

        assertThat(line.isDraw(1)).isNotEqualTo(line.isDraw(2));
    }
}

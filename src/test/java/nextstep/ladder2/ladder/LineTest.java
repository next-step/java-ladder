package nextstep.ladder2.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("생성 테스트")
    void create(){
        LineMaker maker = size1 -> Arrays.asList(true,false,true,false);
        Line line = new Line(maker,4);

        assertThat(line.showLine()).containsExactly(true,false,true,false);
    }
}
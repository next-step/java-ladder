package nextstep.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("인원이 2명 미만이면 라인을 만들 수 없다.")
    @Test
    void createNeedTwoMorePeople() {
        assertThatThrownBy(() -> new Line(1, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이전 지점에 라인이 있을 경우 라인을 생성하지 않는다.")
    @Test
    void notCreateLine() {
        Line line = new Line(5, true);
        List<Boolean> result = line.getLine();
        assertThat(result).containsExactly(true,false,true,false);
    }
}

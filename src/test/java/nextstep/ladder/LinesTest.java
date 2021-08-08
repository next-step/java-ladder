package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    List<Line> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add(Line.INITLINE);
    }

    @Test
    @DisplayName("사다리 줄 생성 true")
    void makeLineTest() {
        int height = 5;

        for(int i = 0; i < height; i++) {
            Lines lines = Lines.of(list, 4, () -> true);
            assertThat(lines).isEqualTo(Lines.of(list, 4, () -> true));
        }
    }

    @Test
    @DisplayName("사다리 줄 생성 false")
    void makeLineFalseTest() {
        int height = 5;

        for(int i = 0; i < height; i++) {
            Lines lines = Lines.of(list, 3, () -> false);
            assertThat(lines).isEqualTo(Lines.of(list, 3, () -> false));
        }
    }

}

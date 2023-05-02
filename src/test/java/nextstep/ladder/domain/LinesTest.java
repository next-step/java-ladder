package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    @DisplayName("lines 생성 테스트")
    void createLinesTest() {
        Line line1 = new Line(true);
        Line line2 = new Line(false);

        Lines lines = new Lines(List.of(line1, line2));

        assertThat(lines.getNumberOfLines())
                .isEqualTo(2);
    }

    @Test
    @DisplayName("lines 초기화 테스트")
    void initLinesTest() {
        Participants participants = Participants.init(new String[]{"a", "b", "c"});
        Lines lines = Lines.init(participants, previous -> true);

        assertThat(lines.getNumberOfLines())
                .isEqualTo(3);
    }



}
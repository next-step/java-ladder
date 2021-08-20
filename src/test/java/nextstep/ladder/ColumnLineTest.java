package nextstep.ladder;

import nextstep.ladder.application.PlayLadder;
import nextstep.ladder.domain.ladder.ColumnLine;
import nextstep.ladder.domain.ladder.Height;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ColumnLineTest {

    @Test
    @DisplayName("사다리 라인 생성")
    void createLineTest() {
        int heightInteger = 5;
        ColumnLine columnLine = new ColumnLine(new Height(heightInteger));
        assertThat(columnLine.getPoints().size()).isEqualTo(heightInteger);
    }

    @Test
    @DisplayName("사다리 라인 에러")
    void createLineExceptionTest() {
        int invalidHeightInteger = 0;
        assertThatThrownBy(() -> {
            new ColumnLine(new Height(invalidHeightInteger));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과값 매핑")
    void resultMappingTest() {
        int heightInteger = 5;
        String result = "꽝";
        ColumnLine columnLine = new ColumnLine(new Height(heightInteger), result);
        assertThat(columnLine.getResult()).isEqualTo(result);
    }
}

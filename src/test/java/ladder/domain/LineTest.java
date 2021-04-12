package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("Line 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        List<Point> points = new ArrayList<>();

        // when
        Line line = Line.of(points);

        // then
        assertThat(line).isNotNull();
    }
/*
    @DisplayName("Line 인스턴스 참가자 수로 생성 여부 테스트")
    @Test
    void 생성_참가자_수() {
        // given
        int countOfPerson = 4;

        // when
        Line line = Line.of(countOfPerson);

        // then
        assertThat(line).isNotNull();
    }
*/
}
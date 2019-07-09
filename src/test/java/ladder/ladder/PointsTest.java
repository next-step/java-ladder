package ladder.ladder;

import ladder.domain.ladder.unit.Points;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointsTest {
    @Test
    @DisplayName("[success] 셍성시 입력된 startPoint 와 같은지 확인한다.")
    void isStartPointTest() {
        //Given
        int startPoint = 1;
        Points points = Points.from(startPoint);
        
        //When
        boolean sameStartPoint = points.isStartPoint(startPoint);
        
        //Then
        Assertions.assertThat(sameStartPoint).isTrue();
    }
}

package nextstep.ladder.model.ladder;

import nextstep.ladder.strategy.TestPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    
    @Test
    @DisplayName("연결된 포인트 생성 테스트")
    void createConnectedPoint() {
        Point point = Point.of(true);
        assertThat(point.isConnected()).isTrue();
    }
    
    @Test
    @DisplayName("연결되지 않은 포인트 생성 테스트")
    void createDisconnectedPoint() {
        Point point = Point.of(false);
        assertThat(point.isConnected()).isFalse();
    }
    
    @Test
    @DisplayName("포인트 동등성 테스트")
    void pointEquality() {
        Point point1 = Point.of(true);
        Point point2 = Point.of(true);
        Point point3 = Point.of(false);
        
        assertThat(point1).isEqualTo(point2);
        assertThat(point1).isNotEqualTo(point3);
    }

    @Test
    @DisplayName("포인트 생성기를 사용한 포인트 생성 테스트")
    void createPointWithGenerator() {
        Point connectedPoint = Point.create(new TestPointGenerator(true));
        Point disconnectedPoint = Point.create(new TestPointGenerator(false));
        
        assertThat(connectedPoint.isConnected()).isTrue();
        assertThat(disconnectedPoint.isConnected()).isFalse();
    }
} 

package nextstep.ladder.model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {
    
    @Test
    @DisplayName("위치 생성 테스트")
    void createPosition() {
        Position position = new Position(1);
        assertThat(position.getValue()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("음수 위치 생성 시 예외 발생 테스트")
    void createNegativePosition() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Position(-1))
            .withMessageContaining("위치는 음수가 될 수 없습니다");
    }
    
    @Test
    @DisplayName("왼쪽으로 이동 테스트")
    void moveLeft() {
        Position position = new Position(2);
        Position movedPosition = position.moveLeft();
        
        assertThat(movedPosition.getValue()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("0 위치에서 왼쪽으로 이동 시 같은 위치 반환 테스트")
    void moveLeftFromZero() {
        Position position = new Position(0);
        Position movedPosition = position.moveLeft();
        
        assertThat(movedPosition).isEqualTo(position);
    }
    
    @Test
    @DisplayName("오른쪽으로 이동 테스트")
    void moveRight() {
        Position position = new Position(1);
        Position movedPosition = position.moveRight();
        
        assertThat(movedPosition.getValue()).isEqualTo(2);
    }
    
    @Test
    @DisplayName("위치 유효성 검사 테스트")
    void isValidPosition() {
        Position position = new Position(2);
        
        assertThat(position.isValid(5)).isTrue();
        assertThat(position.isValid(2)).isFalse();
    }
    
    @Test
    @DisplayName("위치 동등성 테스트")
    void positionEquality() {
        Position position1 = new Position(1);
        Position position2 = new Position(1);
        Position position3 = new Position(2);
        
        assertThat(position1).isEqualTo(position2);
        assertThat(position1).isNotEqualTo(position3);
    }
} 

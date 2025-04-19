package nextstep.ladder.model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {
    
    @Test
    @DisplayName("위치 생성 테스트")
    void createPosition() {
        Position position = new Position(1);
        assertThat(position.getValue()).isEqualTo(1);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})
    @DisplayName("음수 위치 생성 시 예외 발생 테스트")
    void createNegativePosition(int invalidPosition) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Position(invalidPosition))
            .withMessageContaining("위치는 음수가 될 수 없습니다");
    }
    
    @ParameterizedTest
    @CsvSource({"2,1", "5,4", "10,9"})
    @DisplayName("왼쪽으로 이동 테스트")
    void moveLeft(int initialPosition, int expectedPosition) {
        Position position = new Position(initialPosition);
        Position movedPosition = position.moveLeft();
        
        assertThat(movedPosition.getValue()).isEqualTo(expectedPosition);
    }
    
    @Test
    @DisplayName("0 위치에서 왼쪽으로 이동 시 같은 위치 반환 테스트")
    void moveLeftFromZero() {
        Position position = new Position(0);
        Position movedPosition = position.moveLeft();
        
        assertThat(movedPosition).isEqualTo(position);
    }
    
    @ParameterizedTest
    @CsvSource({"1,2", "4,5", "9,10"})
    @DisplayName("오른쪽으로 이동 테스트")
    void moveRight(int initialPosition, int expectedPosition) {
        Position position = new Position(initialPosition);
        Position movedPosition = position.moveRight();
        
        assertThat(movedPosition.getValue()).isEqualTo(expectedPosition);
    }
    
    @ParameterizedTest
    @CsvSource({"2,5,true", "2,2,false", "4,3,false", "0,3,true"})
    @DisplayName("위치 유효성 검사 테스트")
    void isValidPosition(int positionValue, int maxPosition, boolean expectedValidity) {
        Position position = new Position(positionValue);
        
        assertThat(position.isValid(maxPosition)).isEqualTo(expectedValidity);
    }
    
    @ParameterizedTest
    @CsvSource({"1,1,true", "1,2,false", "2,1,false", "3,3,true"})
    @DisplayName("위치 동등성 테스트")
    void positionEquality(int position1Value, int position2Value, boolean expectedEquality) {
        Position position1 = new Position(position1Value);
        Position position2 = new Position(position2Value);
        
        assertThat(position1.equals(position2)).isEqualTo(expectedEquality);
    }
} 

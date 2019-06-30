package ladder.ladder;

import ladder.domain.ladder.Cell;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CellTest {
    @Test
    @DisplayName("[success] 연결선을 연결할지의 여부를 파라미터로 넘겨 연결선이 연결된 객체를 생성한다.")
    void isConnectedTest() {
        //Given
        Cell cell = Cell.from(true);
        
        //When
        boolean isConnected = cell.isRightConnected();
        
        //Then
        Assertions.assertThat(isConnected).isTrue();
    }
    
    @Test
    @DisplayName("[success] 오른쪽이 연결된 객체를 매개변수로 받아 왼쪽이 연결된 객체를 생성한다.")
    void isConnectedLeftTest() {
        //Given
        Cell rightConnectedCell = Cell.from(true);
        
        //When
        Cell leftConnectedCell = Cell.from(rightConnectedCell, true);
        boolean isConnected = leftConnectedCell.isLeftConnected();
        
        //Then
        Assertions.assertThat(isConnected).isTrue();
    }
}

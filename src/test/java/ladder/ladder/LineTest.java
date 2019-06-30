package ladder.ladder;

import ladder.domain.ladder.unit.Cell;
import ladder.domain.ladder.unit.Line;
import ladder.domain.ladder.message.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("[success] 생성시 Cell 의 갯수를 받아 해당 갯수만큼의 Cell 을 생성한다.")
    void makeCellsSuccessTest() {
        //Given
        int maxCellsSize = 5;
        
        //When
        Line line = Line.from(maxCellsSize);
        int cellsSize = line.getSize();
        
        //Then
        Assertions.assertThat(cellsSize).isEqualTo(maxCellsSize);
    }
    
    @Test
    @DisplayName("[fail] 생성시 Cell 의 갯수는 0개를 입력할 수 없다.")
    void makeCellsFailTest() {
        //Given
        int maxCellSize = 0;
        
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Line.from(maxCellSize))
          .withMessage(ErrorMessages.CANT_INPUT_LESS_THAN_ZERO.message());
    }
    
    
    @Test
    @DisplayName("[success] 이전에 생성된 Line 를 받아 연결선이 중복되지 않는 Line 를 생성한다.")
    void makeCellsDuplicateTest() {
        //Given
        int cellsSize = 5;
        Line beforeLine = Line.from(cellsSize);
        
        //When
        Line afterLine = Line.from(beforeLine, false);
        
        //Then
        boolean same = false;
        for (int i = 0; i < cellsSize; i++) {
            boolean beforeCellRightConnected = beforeLine.get(i).isRightConnected();
            
            if (beforeCellRightConnected) {
                if (beforeCellRightConnected == afterLine.get(i).isRightConnected()) {
                    same = true;
                    break;
                }
            }
        }
        
        Assertions.assertThat(same).isFalse();
    }
    
    @Test
    @DisplayName("[success] 마지막 Line 는 오른쪽 연결선이 없다.")
    void makeCellsLastTest() {
        //Given
        int cellsSize = 5;
        Line beforeLine = Line.from(cellsSize);
        Line afterLine = Line.from(beforeLine, true);
        
        //When
        boolean noneMatchRightConnected = afterLine.getStream()
          .noneMatch(Cell::isRightConnected);
        
        //Then
        Assertions.assertThat(noneMatchRightConnected).isTrue();
    }
    
}

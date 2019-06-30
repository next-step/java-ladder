package ladder.ladder;

import ladder.domain.ladder.Cell;
import ladder.domain.ladder.Row;
import ladder.domain.ladder.message.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RowTest {
    @Test
    @DisplayName("[success] 생성시 Cell 의 갯수를 받아 해당 갯수만큼의 Cell 을 생성한다.")
    void makeCellsSuccessTest() {
        //Given
        int maxCellsSize = 5;
        
        //When
        Row row = Row.from(maxCellsSize);
        int cellsSize = row.getSize();
        
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
          .isThrownBy(() -> Row.from(maxCellSize))
          .withMessage(ErrorMessages.CANT_INPUT_LESS_THAN_ZERO.message());
    }
    
    
    @Test
    @DisplayName("[success] 이전에 생성된 Row 를 받아 연결선이 중복되지 않는 Row 를 생성한다.")
    void makeCellsDuplicateTest() {
        //Given
        int cellsSize = 5;
        Row beforeRow = Row.from(cellsSize);
        
        //When
        Row afterRow = Row.from(beforeRow, false);
        
        //Then
        boolean same = false;
        for (int i = 0; i < cellsSize; i++) {
            boolean beforeCellRightConnected = beforeRow.get(i).isRightConnected();
            
            if (beforeCellRightConnected) {
                if (beforeCellRightConnected == afterRow.get(i).isRightConnected()) {
                    same = true;
                    break;
                }
            }
        }
        
        Assertions.assertThat(same).isFalse();
    }
    
    @Test
    @DisplayName("[success] 마지막 Row 는 오른쪽 연결선이 없다.")
    void makeCellsLastTest() {
        //Given
        int cellsSize = 5;
        Row beforeRow = Row.from(cellsSize);
        Row afterRow = Row.from(beforeRow, true);
        
        //When
        boolean noneMatchRightConnected = afterRow.getStream()
          .noneMatch(Cell::isRightConnected);
        
        //Then
        Assertions.assertThat(noneMatchRightConnected).isTrue();
    }
    
}

package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LinesTest {
    @DisplayName("Lines 가 생성된다")
    @Test
    public void linesInstance() {
        //given
        //when
        Lines lines = Lines.of(40, 20, 20);
        //then
        assertAll("Lines 가 입력한 파라미터에 맞게 생성된다",
                () -> assertThat(lines.lineCount())
                        .as("생성 라인 수대로 잘 만들어진다")
                        .isEqualTo(20),
                () -> assertThat(lines.allLines())
                        .as("모든 Line 의 존재여부를 확인할 수 있다")
                        .allMatch(lines::existLine)
        );
    }


//    @DisplayName("")
//    @Test
//    public void () {
//        //given
//        Lines lines = Lines.of(List.of(Line.of()))
//        //when
//        //then
//        isExistSameColumnAndAdjacentRow()
//    }
}
package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LinesTest {
    @DisplayName("")
    @Test
    public void linesInstance() {
        //given
        //when
        Lines lines = new Lines(100, 20, 20);
        //then
        assertAll("",
                () -> assertThat(lines.lineCount())
                        .as("생성 라인 수대로 잘 만들어진다")
                        .isEqualTo(20),
                () -> assertThat(lines.allLines())
                        .as("모든 Line 의 위치는 범위 내 이어야한다")
                        .allMatch(line -> {
                            return line.getHorizontalPosition() < 100 && line.getVerticalPosition() < 20;
                        })
        );

    }
}
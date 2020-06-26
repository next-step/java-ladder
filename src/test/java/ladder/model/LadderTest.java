package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @DisplayName("사다리 높이 출력 갯수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:3", "6:2", "5:4"}, delimiter = ':')
    void countLinesTest(int height, int countOfperson){
        Ladder ladder = Ladder.create(countOfperson, LadderHeight.create(height).getHeight());

        assertThat(ladder.getLines()).hasSize(height);
    }
}
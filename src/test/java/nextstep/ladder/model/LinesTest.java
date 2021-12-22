package nextstep.ladder.model;

import nextstep.ladder.factory.LinesFactory;
import nextstep.ladder.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    @DisplayName("Lines 출력 테스트")
    void viewCheck() {
        Lines lines = LinesFactory.of(10, 20);
        OutputView.print(lines);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "2,2", "3,3"})
    @DisplayName("move 테스트")
    void move(int index, int output) {
        Player player = new Player("test", index);
        Lines lines = LinesFactory.of(true, 4, 2, prev -> !prev);
        //                  test
        // |-----|     |-----|
        // |-----|     |-----|
        //                  test
        lines.move(player);
        assertThat(player.getIndex()).isEqualTo(new Index(output));
    }
}
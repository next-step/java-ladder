package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {
    @Test
    public void 연속된_계단은_생성될수없다() {
        List<Boolean> line = new ArrayList<>();
        line.add(true);
        line.add(true);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Line(line);
        });
    }

    @Test
    public void 사람수를_입력하면_사람수보다_하나작은_사다리가_만들어진다() {
        int countOfPeople = 10;
        Line line = new Line(countOfPeople);

        assertThat(line.size()).isEqualTo(countOfPeople - 1);
    }
}
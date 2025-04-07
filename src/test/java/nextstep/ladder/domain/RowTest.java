package nextstep.ladder.domain;

import java.util.List;

import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.JunctionTest.createJunctions1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIndexOutOfBoundsException;

class RowTest {

    @Test
    void Row의_연결횟수_만큼_RungStategy가_실행된다() {
        int junctionSize = 3;
        List<Junction> junctions = createJunctions1(junctionSize);

        Row row = new Row(junctions);
        MockRungStrategy mockRungStrategy = new MockRungStrategy();
        row.applyRungs(mockRungStrategy);

        assertThat(mockRungStrategy.getApplyCallCount()).isEqualTo(junctionSize - 1);
    }

    @Test
    void getJunction_에서_벗어나는_인덱스에_접근하면_예외가_발생한다() {
        List<Junction> junctions = createJunctions1(2);

        Row row = new Row(junctions);

        IndexOutOfBoundsException e = catchIndexOutOfBoundsException(() -> row.getJunction(3));

        assertThat(e).hasMessage("Index 3 out of bounds for length 2");
    }

}

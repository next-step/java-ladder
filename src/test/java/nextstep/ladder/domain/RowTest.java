package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIllegalArgumentException;
import static org.assertj.core.api.Assertions.catchIndexOutOfBoundsException;

class RowTest {

    @Test
    void CreateIfPossibleRungStrategy는_가능하다면_rung을_만든다() {
        int height = 5;

        List<Leg> legs
            = LegFactory.createLegs(Arrays.asList("test1", "test2", "test3"), height);
        Ladder ladder = new Ladder(legs);
        Row row = ladder.getRow(2);
        row.createRungs(new CreateIfPossibleRungStrategy());

        Junction j1 = row.getJunction(0);
        assertThat(j1.hasLeft()).isFalse();
        assertThat(j1.hasRight()).isTrue();
        assertThat(j1.hasConnect()).isTrue();

        Junction j2 = row.getJunction(1);
        assertThat(j2.hasLeft()).isTrue();
        assertThat(j2.hasRight()).isFalse();
        assertThat(j2.hasConnect()).isTrue();

        Junction j3 = row.getJunction(2);
        assertThat(j3.hasLeft()).isFalse();
        assertThat(j3.hasRight()).isFalse();
        assertThat(j3.hasConnect()).isFalse();
    }

    @Test
    void NoCreateRungStrategy는_rung을_만들지_않는다() {
        int height = 5;

        List<Leg> legs = LegFactory.createLegs(Arrays.asList("test1", "test2"), height);
        Ladder ladder = new Ladder(legs);
        Row row = ladder.getRow(2);
        row.createRungs(new NoCreateRungStrategy());

        Junction j1 = row.getJunction(0);
        assertThat(j1.hasLeft()).isFalse();
        assertThat(j1.hasRight()).isFalse();
        assertThat(j1.hasConnect()).isFalse();

        Junction j2 = row.getJunction(1);
        assertThat(j2.hasLeft()).isFalse();
        assertThat(j2.hasRight()).isFalse();
        assertThat(j2.hasConnect()).isFalse();
    }

    @Test
    void getJunction_에서_벗어나는_인덱스에_접근하면_예외가_발생한다() {
        int height = 5;

        List<Leg> legs = LegFactory.createLegs(Arrays.asList("test1", "test2"), height);
        Ladder ladder = new Ladder(legs);
        Row row = ladder.getRow(2);

        IndexOutOfBoundsException e = catchIndexOutOfBoundsException(() -> row.getJunction(3));

        assertThat(e).hasMessage("Index 3 out of bounds for length 2");
    }

}

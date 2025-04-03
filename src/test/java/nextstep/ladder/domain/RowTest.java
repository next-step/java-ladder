package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIndexOutOfBoundsException;

class RowTest {

    @Test
    void CreateIfPossibleRungStrategy는_가능하다면_rung을_만든다() {
        List<Junction> junctions = IntStream.range(0, 3)
            .mapToObj(i -> new Junction())
            .collect(Collectors.toList());

        Row row = new Row(junctions);
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
        List<Junction> junctions = IntStream.range(0, 2)
            .mapToObj(i -> new Junction())
            .collect(Collectors.toList());

        Row row = new Row(junctions);
        row.createRungs(new NeverCreateRungStrategy());

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
        List<Junction> junctions = IntStream.range(0, 2)
            .mapToObj(i -> new Junction())
            .collect(Collectors.toList());

        Row row = new Row(junctions);

        IndexOutOfBoundsException e = catchIndexOutOfBoundsException(() -> row.getJunction(3));

        assertThat(e).hasMessage("Index 3 out of bounds for length 2");
    }

}

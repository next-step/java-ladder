package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("Ladder 생성시, 전달한 갯수만큼 lines 생성되어야 한다.")
    void createHeightSizeTest() throws NoSuchFieldException, IllegalAccessException {
        Ladder ladder = Ladder.create(5, 10);

        List<Line> linesByReflection = getLinesByReflection(ladder);

        assertThat(linesByReflection).hasSize(5);
        assertThat(linesByReflection.get(0).getPoints()).hasSize(9);
        System.out.println(ladder);
    }

    @Test
    @DisplayName("Ladder 생성시, 생성되는 각 Line의 갯수는, 참가자의 수 -1 이다.")
    void createLineInPointSizeTest() throws NoSuchFieldException, IllegalAccessException {

        int participantsCount = 10;
        Ladder ladder = Ladder.create(5, participantsCount);

        List<Line> linesByReflection = getLinesByReflection(ladder);

        assertThat(linesByReflection.get(0).getPoints()).hasSize(participantsCount - 1);
    }

    @SuppressWarnings("unchecked")
    private List<Line> getLinesByReflection(Ladder ladder)
        throws NoSuchFieldException, IllegalAccessException {
        Field linesField = Ladder.class.getDeclaredField("lines");
        linesField.setAccessible(true);
        return (List<Line>) linesField.get(ladder);
    }
}

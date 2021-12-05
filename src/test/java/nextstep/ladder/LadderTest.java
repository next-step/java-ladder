package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("Ladder 생성시, 전달한 갯수만큼 List가 생성되어야 한다.")
    void createTest() throws NoSuchFieldException, IllegalAccessException {
        Ladder ladder = Ladder.create(5, 10);

        List<Line> linesByReflection = getLinesByReflection(ladder);

        assertThat(linesByReflection).hasSize(5);

        System.out.println(ladder);
    }

    @SuppressWarnings("unchecked")
    private List<Line> getLinesByReflection(Ladder ladder)
        throws NoSuchFieldException, IllegalAccessException {
        Field linesField = Ladder.class.getDeclaredField("lines");
        linesField.setAccessible(true);
        return (List<Line>) linesField.get(ladder);
    }
}

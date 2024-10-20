package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.ganerator.LadderGenerator;
import step2.ganerator.RandomGenerator;
import step2.model.Ladder;
import step2.model.Line;
import step2.util.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 사다리 한줄 생성할 시 첫번째 계단은 무조건 false
- 인원수대로 라인을 생성한다.
*/
public class LineTest {

    @DisplayName("사다리 한줄 생성할 시 첫번째 계단은 무조건 false")
    @Test
    void createLineTest() {
        String[] personArr = StringUtil.divideNum("pobi,honux,crong,jk");
        RandomGenerator randomGenerator = () -> true;
        Line line = Line.createLine(personArr, randomGenerator);
        assertThat(line.getPoints()).containsExactly(false, true, false, true);
    }

    @DisplayName("인원수대로 라인을 생성한다.")
    @Test
    void createLinePersonTest() {
        String[] personArr = StringUtil.divideNum("pobi,honux,crong,jk");
        Line line = Line.createLine(personArr, new LadderGenerator());
        assertThat(line.getPoints().size()).isEqualTo(4);
    }
}

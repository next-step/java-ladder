package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LinesTest {

    @Test
    public void create() throws Exception {
        LadderHeight ladderHeight = new LadderHeight(3);
        assertThat(new Lines(ladderHeight, 5).size()).isEqualTo(ladderHeight.getHeight());
    }

    @Test
    public void create_라인_너비_예외() throws Exception {
        LadderHeight ladderHeight = new LadderHeight(3);
        assertThatThrownBy(() -> {
            new Lines(ladderHeight, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void create_사다리_높이_예외() throws Exception {
        List<Line> lines = Arrays.asList();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lines(lines);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 결과검증() throws Exception {
        UserNames userNames = UserNames.of(new String[]{"NAME1", "NAME2"});
        Line line = Line.of(Arrays.asList(true, false));
        Lines lines = new Lines(Arrays.asList(line));
        ResultMap result = lines.getResult(userNames, new String[]{"RESULT1", "RESULT2"});

        assertThat(result.getResult("NAME1")).isEqualTo("RESULT2");
        assertThat(result.getResult("NAME2")).isEqualTo("RESULT1");
    }

    @Test
    public void 결과검증_사다리_2x2() throws Exception {
        Line line1 = Line.of(Arrays.asList(true, false));
        Line line2 = Line.of(Arrays.asList(true, false));
        Lines lines = new Lines(Arrays.asList(line1, line2));
        UserNames userNames = UserNames.of(new String[]{"NAME1", "NAME2"});
        ResultMap result = lines.getResult(userNames, new String[]{"RESULT1", "RESULT2"});

        assertThat(result.getResult("NAME1")).isEqualTo("RESULT1");
        assertThat(result.getResult("NAME2")).isEqualTo("RESULT2");
    }

    @Test
    public void 결과검증_사다리_2x3() throws Exception {
        Line line1 = Line.of(Arrays.asList(true, false, true));
        Line line2 = Line.of(Arrays.asList(false, true, false));
        Lines lines = new Lines(Arrays.asList(line1, line2));

        UserNames userNames = UserNames.of(new String[]{"NAME1", "NAME2", "NAME3"});
        ResultMap result = lines.getResult(userNames, new String[]{"RESULT1", "RESULT2", "RESULT3"});

        assertThat(result.getResult("NAME1")).isEqualTo("RESULT3");
        assertThat(result.getResult("NAME2")).isEqualTo("RESULT1");
        assertThat(result.getResult("NAME3")).isEqualTo("RESULT2");
    }

    @Test
    public void 결과검증_사다리_2x4() throws Exception {
        Line line1 = Line.of(Arrays.asList(true, false, true, false));
        Line line2 = Line.of(Arrays.asList(false, true, false, false));
        Lines lines = new Lines(Arrays.asList(line1, line2));

        UserNames userNames = UserNames.of(new String[]{"NAME1", "NAME2", "NAME3", "NAME4"});
        ResultMap result = lines.getResult(userNames, new String[]{"RESULT1", "RESULT2", "RESULT3", "RESULT4"});

        assertThat(result.getResult("NAME1")).isEqualTo("RESULT3");
        assertThat(result.getResult("NAME2")).isEqualTo("RESULT1");
        assertThat(result.getResult("NAME3")).isEqualTo("RESULT4");
        assertThat(result.getResult("NAME4")).isEqualTo("RESULT2");
    }

    @Test
    public void 결과검증_사다리_3x3() throws Exception {
        Line line1 = Line.of(Arrays.asList(false, true, false));
        Line line2 = Line.of(Arrays.asList(false, false, false));
        Line line3 = Line.of(Arrays.asList(true, false, false));
        Lines lines = new Lines(Arrays.asList(line1, line2, line3));

        UserNames userNames = UserNames.of(new String[]{"NAME1", "NAME2", "NAME3"});
        ResultMap result = lines.getResult(userNames, new String[]{"RESULT1", "RESULT2", "RESULT3"});

        assertThat(result.getResult("NAME1")).isEqualTo("RESULT2");
        assertThat(result.getResult("NAME2")).isEqualTo("RESULT3");
        assertThat(result.getResult("NAME3")).isEqualTo("RESULT1");
    }
}

package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("선")
public class LineTest {

    @DisplayName("횡단선 그리기 - 전부 그리기")
    @Test
    public void drawTransverseBar_전부그리기() {
        assertThat(Line.drawTransverseBar(5, countOfPerson -> IntStream.range(0, countOfPerson)
                .mapToObj(i -> true)
                .collect(Collectors.toList()))).contains(true, true, true, true, true);
    }

    @DisplayName("횡단선 그리기 - 전부 안그리기")
    @Test
    public void drawTransverseBar_전부안그리기() {
        assertThat(Line.drawTransverseBar(5, countOfPerson -> IntStream.range(0, countOfPerson)
                .mapToObj(i -> false)
                .collect(Collectors.toList()))).contains(false, false, false, false, false);
    }

    @DisplayName("횡단선 그리기 - 번갈아가면서 그리기1(true먼저)")
    @Test
    public void drawTransverseBar_번갈아가면서_그리기1() {
        assertThat(Line.drawTransverseBar(5, countOfPerson -> IntStream.range(0, countOfPerson)
                .mapToObj(i -> i % 2 == 0)
                .collect(Collectors.toList()))).contains(true, false, true, false, true);
    }

    @DisplayName("횡단선 그리기 - 번갈아가면서 그리기2(false먼저)")
    @Test
    public void drawTransverseBar_번갈아가면서_그리기2() {
        assertThat(Line.drawTransverseBar(5, countOfPerson -> IntStream.range(0, countOfPerson)
                .mapToObj(i -> i % 2 == 1)
                .collect(Collectors.toList()))).contains(false, true, false, true, false);
    }

}

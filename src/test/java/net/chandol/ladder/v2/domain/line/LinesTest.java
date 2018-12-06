package net.chandol.ladder.v2.domain.line;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LinesTest {
    @Test
    public void 컬럼문자열생성하기() {
        Lines lines = new ManualLinesGenerator(
                Line.of(false), Line.of(true), Line.of(false)
        ).generate(3, 1);

        Assertions.assertThat(lines.createColumnString(0)).isEqualTo("  |     |-----|     ");
    }

    @Test
    public void 사다리문자열생성하기() {
        Lines lines = new ManualLinesGenerator(
                Line.of(true, false),
                Line.of(false, false)
        ).generate(2, 2);

        Assertions.assertThat(lines.createLinesString()).containsExactly("  |-----|     ", "  |     |     ");
    }

    @Test
    public void 이동테스트_직진() {
        Lines lines = new ManualLinesGenerator(Line.of(false)).generate(1, 1);

        int resultLine = lines.calculateResult(0);
        Assertions.assertThat(resultLine).isEqualTo(0);
    }

    @Test
    public void 이동테스트_오른쪽() {
        Lines lines = new ManualLinesGenerator(
                Line.of(true), Line.of(false)
        ).generate(2, 1);

        int resultLine = lines.calculateResult(0);
        Assertions.assertThat(resultLine).isEqualTo(1);
    }

    @Test
    public void 이동테스트_왼쪽() {
        Lines lines = new ManualLinesGenerator(
                Line.of(true), Line.of(false)
        ).generate(2, 1);

        int resultLine = lines.calculateResult(1);
        Assertions.assertThat(resultLine).isEqualTo(0);
    }

    @Test
    public void 이동테스트_높이가2개이상() {
        Lines lines = new ManualLinesGenerator(
                Line.of(true, false), Line.of(false, true), Line.of(false, false)
        ).generate(3, 2);

        int resultLine = lines.calculateResult(0);
        Assertions.assertThat(resultLine).isEqualTo(2);
    }

}

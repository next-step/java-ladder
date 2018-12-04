package net.chandol.ladder.v2.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LinesTest {
    @Test
    public void 컬럼문자열생성하기() {
        Lines lines = new ManualLinesGenerator(
                Line.of(false), Line.of(true), Line.of(false)
        ).generate(3,1);

        Assertions.assertThat(lines.createColumnString(0)).isEqualTo("  |     |-----|     ");
    }


    @Test
    public void 사다리문자열생성하기() {
        Lines lines = new ManualLinesGenerator(
                Line.of(true, false),
                Line.of(false, false)
        ).generate(2,2);

        Assertions.assertThat(lines.createLinesString()).containsExactly("  |-----|     ", "  |     |     ");
    }

}

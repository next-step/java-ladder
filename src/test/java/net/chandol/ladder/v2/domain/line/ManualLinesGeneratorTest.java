package net.chandol.ladder.v2.domain.line;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLinesGeneratorTest {
    @Test
    public void 생성테스트() {
        ManualLinesGenerator generator = new ManualLinesGenerator(
                Line.of(true, false),
                Line.of(false, false)
        );

        Lines lines = generator.generate(2, 2);

        assertThat(lines.get(0)).isEqualTo(Line.of(true, false));
    }
}
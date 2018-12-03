package net.chandol.ladder.v2.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class ManualLinesGeneratorTest {
    @Test
    public void 생성테스트() {
        ManualLinesGenerator generator = new ManualLinesGenerator(
                Line.of(true, false),
                Line.of(false, false)
        );

        List<Line> lines = generator.generate(2, 2);

        Assertions.assertThat(lines.get(0)).isEqualTo(Line.of(true, false));
    }
}
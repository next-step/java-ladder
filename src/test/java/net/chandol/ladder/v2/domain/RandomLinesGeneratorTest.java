package net.chandol.ladder.v2.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RandomLinesGeneratorTest {

    @Test
    public void 랜덤라인생성테스트() {
        RandomLinesGenerator generator = new RandomLinesGenerator();
        int size = 10;
        int height = 3;

        List<Line> lines = generator.generate(size, height);

        Assertions.assertThat(lines.size()).isEqualTo(10);
        Assertions.assertThat(lines).allMatch(l -> l.height() == 3);
    }
}
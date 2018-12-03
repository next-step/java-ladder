package net.chandol.ladder.v2.domain;

import net.chandol.ladder.v2.domain.RandomLinesGenerator.RandomBridgesSupplierUtil;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLinesGeneratorTest {

    @Test
    public void 랜덤라인생성테스트() {
        RandomLinesGenerator generator = new RandomLinesGenerator();
        int size = 10;
        int height = 3;

        Lines lines = generator.generate(size, height);

        assertThat(lines.size()).isEqualTo(10);
        assertThat(lines).allMatch(l -> l.height() == 3);
    }

    @Test
    public void 다리연속여부확인_연속되는경우() {
        List<Boolean> target = Arrays.asList(true, true);
        RandomBridgesSupplierUtil.isBooleansContinuance(target);
    }


    @Test
    public void 다리연속여부확인_정상케이스() {
        List<Boolean> target = Arrays.asList(false, true);
        RandomBridgesSupplierUtil.isBooleansContinuance(target);
    }
}
package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


class RandomBooleanGeneratorTest {
    @Test
    public void 랜덤_boolean_생성기() throws Exception {
        List<Boolean> booleanList = IntStream.range(0, 10)
                .mapToObj(i -> RandomBooleanGenerator.getRandomBoolean())
                .collect(Collectors.toList());

        assertThat(booleanList)
                .containsOnly(Boolean.TRUE, Boolean.FALSE);
    }

}

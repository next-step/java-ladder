package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.domain.generator.CombinationGenerator.generateCombinations;
import static org.assertj.core.api.Assertions.assertThat;

public class CombinationsGeneratorTest {

    @Test
    public void 연속된TRUE를_제외한_모든조합을_생성한다() {
        int n = 3; // 원하는 길이 입력
        List<List<Boolean>> result = new ArrayList<>();
        generateCombinations(n, new ArrayList<>(), result);

        assertThat(result).hasSize(5);
    }

}

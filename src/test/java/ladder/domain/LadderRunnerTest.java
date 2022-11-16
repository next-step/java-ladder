package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRunnerTest {

    @Test
    @DisplayName("가능한 모든 길이 연결된 사다리 결과 테스트")
    void run() {
        int height = 6;
        List<Name> names = List.of(new Name("a"), new Name("b"), new Name("c"), new Name("d"), new Name("e"));
        Ladder ladder = new Ladder(height, names.size(), () -> true);
        List<String> results = List.of("1", "2", "3", "4", "5");

        Map<Name, String> ladderResult = new LadderRunner(names, ladder).run(height, results);

        assertThat(ladderResult).containsEntry(new Name("a"), "4");
        assertThat(ladderResult).containsEntry(new Name("b"), "5");
        assertThat(ladderResult).containsEntry(new Name("c"), "2");
        assertThat(ladderResult).containsEntry(new Name("d"), "3");
        assertThat(ladderResult).containsEntry(new Name("e"), "1");
    }
}

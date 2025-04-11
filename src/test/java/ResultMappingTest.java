import domain.PlayerName;
import org.junit.jupiter.api.Test;
import view.ResultMapping;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class ResultMappingTest {

    @Test
    void 이름과_결과_수_불일치시_예외발생() {
        List<PlayerName> names = List.of(new PlayerName("pobi"), new PlayerName("honux"));
        List<String> outcomes = List.of("꽝");

        assertThatThrownBy(() -> new ResultMapping(names, outcomes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름과 결과의 수가 같아야 합니다.");
    }

    @Test
    void 정상적으로_결과_매핑을_생성한다() {
        List<PlayerName> names = List.of(new PlayerName("pobi"), new PlayerName("honux"));
        List<String> outcomes = List.of("1000", "꽝");

        ResultMapping mapping = new ResultMapping(names, outcomes);

        assertThat(mapping.getResult(new PlayerName("pobi"))).isEqualTo("1000");
        assertThat(mapping.getResult(new PlayerName("honux"))).isEqualTo("꽝");
    }

    @Test
    void 전체_결과를_정확히_반환한다() {
        List<PlayerName> names = List.of(new PlayerName("pobi"), new PlayerName("honux"));
        List<String> outcomes = List.of("꽝", "5000");

        ResultMapping mapping = new ResultMapping(names, outcomes);
        Map<PlayerName, String> allResults = mapping.getAllResults();

        assertThat(allResults).hasSize(2)
                .containsEntry(new PlayerName("pobi"), "꽝")
                .containsEntry(new PlayerName("honux"), "5000");
    }

    @Test
    void getAllResults는_수정_불가능한_맵을_반환한다() {
        List<PlayerName> names = List.of(new PlayerName("pobi"));
        List<String> outcomes = List.of("꽝");

        ResultMapping mapping = new ResultMapping(names, outcomes);
        Map<PlayerName, String> allResults = mapping.getAllResults();

        assertThatThrownBy(() -> allResults.put(new PlayerName("honux"), "5000"))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
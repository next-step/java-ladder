package nextstep.ladder.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ResultsTest {
    private Results results;

    @BeforeEach
    private void before() {
        results = new Results("꽝", "5000", "꽝");
    }

    @Test
    void 생성_비교() {
        Results targetResults = new Results("꽝,5000,꽝");
        assertThat(targetResults).isEqualTo(results);
    }

    @Test
    void 결과_미입력() {
        assertThatThrownBy(() -> {
            new Results("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참가자수와_비교() {
        Members members = new Members("poni,mouse,peace");
        assertThat(results.isEqualMembersCount(members)).isTrue();
    }
}

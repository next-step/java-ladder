package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @DisplayName("입력한 이름으로 실행결과를 찾을수 있다.")
    @Test
    void findOne() {
        Player pobi = new Player("pobi", 0);
        Player crong = new Player("crong", 1);

        Prize lucky = new Prize(0, "lucky");
        Prize blank = new Prize(1, "blank");

        Map<Player, Prize> dump = new HashMap<>();
        dump.put(pobi, lucky);
        dump.put(crong, blank);

        Result result = new Result(dump);

        assertThat(result.findOne("pobi")).isEqualTo("lucky");
        assertThat(result.findOne("crong")).isEqualTo("blank");
    }
}
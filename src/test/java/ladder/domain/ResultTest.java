package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

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
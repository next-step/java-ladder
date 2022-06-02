package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void name() {
        ResultMap resultMap = new ResultMap();
        resultMap.put("player1", "reward");
        assertThat(resultMap.get("player1")).isEqualTo("reward");
        HashMap a = new HashMap<String,String>();
        a.put("a","1");
        System.out.println(a);
    }
}

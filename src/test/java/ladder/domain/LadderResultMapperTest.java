package ladder.domain;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderResultMapperTest {

    @Test
    public void ladderResultMapperTest() {

        String participants = "a,b,c";
        String rewards = "1,2,3";

        String[] p = participants.split(",");
        String[] r = rewards.split(",");

        int size = p.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            map.put(i, p.length - 1 - i);
        }

        LadderResult ladderResult = new LadderResult(map);

        LadderResultMapper ladderResultMapper = new LadderResultMapper(
            ladderResult, new Participants(participants), new Rewards(rewards)
        );

        for (int i = 0; i < p.length; i++) {
            assertEquals(ladderResultMapper.get(p[i]), r[size - 1 - i]);
        }

        for (int i = 0; i < size; i++) {
            assertEquals(ladderResultMapper.getAll().get(i),
                         join(p[i], r[size - 1 - i]));
        }
    }

    private String join(String p, String r) {
        return p + " : " + r;
    }
}

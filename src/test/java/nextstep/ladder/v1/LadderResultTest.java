package nextstep.ladder.v1;

import nextstep.ladder.v1.model.LadderResult;
import nextstep.ladder.v1.model.Player;
import nextstep.ladder.v1.model.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class LadderResultTest {
    @Test
    @DisplayName("LadderResult 생성")
    void createLadderResultTest() {
        //given
        Player player = new Player("pobi");
        Prize prize = new Prize("꽝");
        LinkedHashMap<Player, Prize> prizeLinkedHashMap = new LinkedHashMap<>();
        prizeLinkedHashMap.put(player, prize);

        //when
        LadderResult ladderResult = new LadderResult(prizeLinkedHashMap);

        //then
        Assertions.assertThat(ladderResult).isNotNull();
        LinkedHashMap<Player, Prize> result = ladderResult.getAllResult();
        Assertions.assertThat(result).hasSize(1);
    }
}

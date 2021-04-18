package ladder;

import ladder.domain.GameHelper;
import ladder.domain.Ladder;
import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameHelperTest {
    public final RandomBoolean randomTrueBoolean = new RandomBooleanGenerator() {
        @Override
        public boolean randomBoolean() {
            return true;
        }
    };

    @Test
    public void finalLineTest() {
        // given
        final int line = 6;
        final int height = 3;
        Ladder ladder = Ladder.valueOf(line, height, randomTrueBoolean);

        final List<String> top = Arrays.asList("a", "b", "c", "d", "e", "f");
        final List<String> bottom = Arrays.asList("1등", "2등", "3등", "4등", "5등", "6등");
        GameHelper gameHelper = new GameHelper(top, bottom);
        Map<String, String> expectResult = new HashMap<>();
        expectResult.put("a", "2등");
        expectResult.put("b", "1등");
        expectResult.put("c", "4등");
        expectResult.put("d", "3등");
        expectResult.put("e", "6등");
        expectResult.put("f", "5등");

        //when
        Map<String, String> result = gameHelper.gameResult(ladder);

        // then
        Assertions.assertThat(result).isEqualTo(expectResult);
    }
}

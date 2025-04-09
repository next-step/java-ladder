
import domain.Ladder;
import domain.PlayerName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 플레이어_이름_길이_검증() {
        List<String> rawNames = List.of("kwon", "ohgyu", "bb", "aa");
        List<PlayerName> names = rawNames.stream()
                .map(PlayerName::new)
                .collect(Collectors.toList());

        assertEquals(4, names.size());
        assertEquals("ohgy", names.get(0).getName());
    }

    @Test
    void 잘못된_이름_입력_예외_발생() {
        List<String> rawNames = List.of("ohgyu", "xxxxxxxx"); // 5자 초과
        assertThrows(IllegalArgumentException.class, () -> {
            rawNames.stream()
                    .map(PlayerName::new)
                    .collect(Collectors.toList());
        });
    }

    @Test
    void 사다리_정상_생성_확인() {
        List<String> rawNames = List.of("ohgyu", "kwon", "bb", "jk");
        List<PlayerName> names = rawNames.stream()
                .map(PlayerName::new)
                .collect(Collectors.toList());

        Ladder ladder = new Ladder(names.size(), 5);

        assertNotNull(ladder);
    }
}
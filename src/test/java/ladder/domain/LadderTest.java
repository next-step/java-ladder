package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest {
    private List<Name> names = new ArrayList<>();

    @BeforeEach
    void setUp() {
        names.add(new Name("harr"));
        names.add(new Name("horr"));
        names.add(new Name("hurr"));
        names.add(new Name("hirr"));
        names.add(new Name("herr"));
    }

    @Test
    @DisplayName("사다리를 생성시 파라미터인 Height, personCount를 기반으로 lines의 사이즈, points의 사이즈를 검증한다.")
    void createLadder(){
        int height = 5;
        int personCount = 5;
        Ladder ladder = new Ladder(height, personCount, () -> true);
        List<Line> lines = ladder.lines();
        assertEquals(lines.size(), height);
        lines.stream()
                .forEach(line -> assertEquals(line.points().size(), personCount - 1));
    }
}
package ladder.domain;

import ladder.service.PointGenerator;
import ladder.service.StaticPointGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static ladder.support.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {
    private Ladder ladder;
    private Users users;
    private LadderHeight height;
    private Results results;

    @BeforeEach
    public void setUp() {
        users = new Users(USERS);
        height = new LadderHeight(5);
        results = new Results(RESULTS);
        PointGenerator pointGenerator = new StaticPointGenerator(POINTS);
        ladder = new Ladder(users, results, height, pointGenerator);
    }

    @DisplayName("Ladder 생성 테스트")
    @Test
    public void createLadderTest() {
        List<Line> lines = ladder.getLines();

        assertEquals(height.getHeight(), lines.size());
        assertEquals(users.count() - 1, lines.get(0).getPoints().size());
    }

    @DisplayName("유저 수와 결과 수가 일치하지 않을 때 예외가 발생한다.")
    @Test
    public void createLadderWithDifferentUserAndResultCountTest() {
        Users differentUsers = new Users(List.of("pobi", "honux", "crong"));
        Results differentResults = new Results(List.of("꽝", "3000", "꽝", "5000"));

        try {
            new Ladder(differentUsers, differentResults, height, new StaticPointGenerator(POINTS));
        } catch (IllegalArgumentException e) {
            assertEquals("사용자 수와 결과 수가 일치하지 않습니다.", e.getMessage());
        }
    }

    @DisplayName("유저 결과 확인 테스트")
    @Test
    public void findResultTest() {
        User targetUser = new User("pobi");
        Result result = ladder.findResult(targetUser);

        assertEquals(result.getValue(), "꽝");
    }

    @DisplayName("모든 결과 확인 테스트")
    @Test
    public void findResultAllTest() {
        Map<User, Result> resultMap = ladder.findResultAll();

        assertEquals(resultMap.get(new User("pobi")).getValue(), "꽝");
        assertEquals(resultMap.get(new User("honux")).getValue(), "3000");
        assertEquals(resultMap.get(new User("crong")).getValue(), "꽝");
        assertEquals(resultMap.get(new User("jk")).getValue(), "5000");
    }
}

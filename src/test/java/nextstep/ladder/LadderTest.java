package nextstep.ladder;

import nextstep.ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private List<String> results = IntStream.range(0,5).boxed().map(String::valueOf).collect(Collectors.toUnmodifiableList());
    private int length = 4;
    private int height = 3;

    @Test
    @DisplayName("사다리 생성 테스트")
    void testValidLadder() {
        LineGenerator testLineGenerator = count -> Collections.nCopies(length, Boolean.FALSE);

        Ladder ladder = new Ladder(height, length, testLineGenerator, results);
        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getLines()).hasSize(height);
        assertThat(ladder.getLadderResult()).hasSize(length+1).containsExactlyElementsOf(results);
        assertContainLines(ladder, new Line(length, testLineGenerator), length);
    }

    @Test
    @DisplayName("사다리 결과 테스트")
    void testLadderResult() {
        Ladder ladder = new Ladder(height,length,count -> List.of(true, false, true, false), results);
        Users users = new Users(makeUser());

        GameResult gameResult = ladder.getGameResult(users);
        assertThat(gameResult.getGameResultByUserName("0")).isEqualTo("1");
        assertThat(gameResult.getGameResultByUserName("1")).isEqualTo("0");
        assertThat(gameResult.getGameResultByUserName("2")).isEqualTo("3");
        assertThat(gameResult.getGameResultByUserName("3")).isEqualTo("2");
        assertThat(gameResult.getGameResultByUserName("4")).isEqualTo("4");
    }

    private void assertContainLines(Ladder ladder, Line expectLine, int numberOfUser) {
        List<Line> lines = ladder.getLines();

        lines.forEach(line -> {
            assertThat(line.getLine())
                    .hasSize(numberOfUser)
                    .containsExactlyElementsOf(expectLine.getLine());

            assertThat(line.getLength()).isEqualTo(numberOfUser);
        });
    }

    private static List<User> makeUser() {
        return IntStream.range(0,5).boxed()
                .map(String::valueOf)
                .map(User::new)
                .collect(Collectors.toUnmodifiableList());
    }
}

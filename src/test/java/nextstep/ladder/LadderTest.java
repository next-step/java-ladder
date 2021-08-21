package nextstep.ladder;

import nextstep.ladder.application.PlayLadder;
import nextstep.ladder.domain.ladder.ColumnLine;
import nextstep.ladder.domain.ladder.Direction;
import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.UserName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    Ladder ladder;
    List<User> users = new ArrayList<>();

    @BeforeEach
    void setup() {
        ColumnLine columnLine1 = new ColumnLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.RIGHT), "꽝");
        ColumnLine columnLine2 = new ColumnLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.LEFT), "1000");
        ColumnLine columnLine3 = new ColumnLine(Arrays.asList(Direction.LEFT, Direction.NONE, Direction.NONE), "2000");

        List<ColumnLine> compareColumnLines = Arrays.asList(columnLine1, columnLine2, columnLine3);
        ladder = new Ladder(compareColumnLines);

        users = Arrays.asList(new User("pobi",0),
                                        new User("honux",1),
                                        new User("crong",2));
    }

    @Test
    @DisplayName("사다리 생성")
    void createLadderTest() {
        ColumnLine line1 = new ColumnLine(new Height(3));
        ColumnLine line2 = new ColumnLine(new Height(3));
        ColumnLine line3 = new ColumnLine(new Height(3));

        line1.getPointOfHeight(0)
                .drawRightLine(line2.getPointOfHeight(0), () -> false);
        line2.getPointOfHeight(0)
                .drawRightLine(line3.getPointOfHeight(0), () -> true);

        line1.getPointOfHeight(1)
                .drawRightLine(line2.getPointOfHeight(1), () -> true);
        line2.getPointOfHeight(1)
                .drawRightLine(line3.getPointOfHeight(1), () -> false);

        line1.getPointOfHeight(2)
                .drawRightLine(line2.getPointOfHeight(2), () -> true);
        line2.getPointOfHeight(2)
                .drawRightLine(line3.getPointOfHeight(2), () -> false);

        List<ColumnLine> columnLines = Arrays.asList(line1,line2,line3);
        Ladder compareLadder = new Ladder(columnLines);

        assertThat(compareLadder).isEqualTo(this.ladder);
    }

    @Test
    @DisplayName("사다리 생성, 결과값 포함")
    void createLadderWithResultsTest() {
        List<ColumnLine> columnLines = PlayLadder.createColumnLines(3, 3, Arrays.asList("꽝", "1000", "꽝"));

        ColumnLine compareLine1 = new ColumnLine(new Height(3),"꽝");
        ColumnLine compareLine2 = new ColumnLine(new Height(3),"1000");
        ColumnLine compareLine3 = new ColumnLine(new Height(3),"꽝");

        List<ColumnLine> compareColumnLines = Arrays.asList(compareLine1, compareLine2, compareLine3);

        Ladder ladder = new Ladder(columnLines);
        Ladder compareWithResultLadder = new Ladder(compareColumnLines);

        assertThat(ladder).isEqualTo(compareWithResultLadder);
    }

    @Test
    @DisplayName("사다리 생성 결과값 에러 테스트")
    void inputResultsExceptionTest() {
        assertThatThrownBy(() -> {
            PlayLadder.createLadder(Arrays.asList("aa", "bb", "cc"), 3, Arrays.asList("꽝", "1000"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 게임")
    void playLadderResultUser() {
        User playUser1 = new User(new UserName("pobi"),0);
        User playUser2 = new User(new UserName("honux"),1);
        User playUser3 = new User(new UserName("crong"),2);

        ladder.play(Arrays.asList(playUser1,playUser2,playUser3));
        assertThat(playUser1.getIndexOfColumnLine()).isEqualTo(0);
        assertThat(playUser2.getIndexOfColumnLine()).isEqualTo(2);
        assertThat(playUser3.getIndexOfColumnLine()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi, 꽝", "honux, 2000", "crong, 1000"})
    @DisplayName("결과 보고 싶은 사람")
    void getResultOfUser(String findName, String expectedResult) {
        ladder.play(users);
        User findUser = users.stream()
                .filter(user -> user.getName().equals(findName))
                .findFirst()
                .get();

        assertThat(expectedResult).isEqualTo(ladder.getResultOfLine(findUser.getIndexOfColumnLine()));
    }
}

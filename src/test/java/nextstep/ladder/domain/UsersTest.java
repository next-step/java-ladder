package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class UsersTest {
    public static final Users USERS = new Users(new ArrayList<>(
            Stream.of(new User("pobi"),
                      new User("honux"),
                      new User("crong"),
                      new User("jk")
            )
                  .collect(Collectors.toList())));

    @Test
    void generateResultsForAllPlayers() {
        GameInfo gameInfo = new GameInfo(USERS, ResultsTest.RESULTS);
        List<LadderLine> lineList = Stream.of(LadderLineTest.LINE, LadderLineTest.LINE2)
                                          .collect(Collectors.toList());

        Ladder ladder = new Ladder(lineList);
        USERS.generateResultsForAllPlayers(gameInfo, ladder);
        List<User> users = USERS.getUsers();

        assertThat(users.get(0).getResult()).isEqualTo("꽝");
        assertThat(users.get(1).getResult()).isEqualTo("꽝");
        assertThat(users.get(2).getResult()).isEqualTo("3000");
        assertThat(users.get(3).getResult()).isEqualTo("5000");
    }
}

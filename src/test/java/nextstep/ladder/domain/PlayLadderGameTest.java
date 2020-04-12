package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.view.ResultView;

public class PlayLadderGameTest {
    private static ResultView resultView = ResultView.getResultView();
    private static PlayLadderGame playLadderGame = PlayLadderGame.getPlayLadderGame();
    private Users users;
    private LadderLine line;
    private List<LadderLine> lineList;
    private Ladder ladder;
    private Results results;
    private Users resultUsers;
    private GameInfo gameInfo;

    @BeforeEach
    void setUp() {
        List<ImprovingPoint> points = Stream.of(new ImprovingPoint(0, Direction.of(false, true)),
                                                new ImprovingPoint(1, Direction.of(true, false)),
                                                new ImprovingPoint(2, Direction.of(false, true)),
                                                new ImprovingPoint(3, Direction.of(true, false)))
                                            .collect(Collectors.toList());

        line = new LadderLine(points);

        List<ImprovingPoint> points2 = Stream.of(new ImprovingPoint(0, Direction.of(false, false)),
                                                 new ImprovingPoint(1, Direction.of(false, true)),
                                                 new ImprovingPoint(2, Direction.of(true, false)),
                                                 new ImprovingPoint(3, Direction.of(false, false)))
                                             .collect(Collectors.toList());
        LadderLine line2 = new LadderLine(points2);

        List<ImprovingPoint> points3 = Stream.of(new ImprovingPoint(0, Direction.of(false, true)),
                                                 new ImprovingPoint(1, Direction.of(true, false)),
                                                 new ImprovingPoint(2, Direction.of(false, false)),
                                                 new ImprovingPoint(3, Direction.of(false, false)))
                                             .collect(Collectors.toList());

        LadderLine line3 = new LadderLine(points3);

        List<ImprovingPoint> points4 =  Stream.of(new ImprovingPoint(0, Direction.of(false, false)),
                                                  new ImprovingPoint(1, Direction.of(false, true)),
                                                  new ImprovingPoint(2, Direction.of(true, false)),
                                                  new ImprovingPoint(3, Direction.of(false, false)))
                                              .collect(Collectors.toList());

        LadderLine line4 = new LadderLine(points4);

        List<ImprovingPoint> points5 = Stream.of(new ImprovingPoint(0, Direction.of(false, true)),
                                                 new ImprovingPoint(1, Direction.of(true, false)),
                                                 new ImprovingPoint(2, Direction.of(false, true)),
                                                 new ImprovingPoint(3, Direction.of(true, false)))
                                             .collect(Collectors.toList());
        LadderLine line5 = new LadderLine(points5);

        lineList = Stream.of(line, line2, line3, line4, line5)
                         .collect(Collectors.toList());

        ladder = new Ladder(lineList);

        users = new Users(new ArrayList<>(
                Stream.of(new User("pobi"),
                          new User("honux"),
                          new User("crong"),
                          new User("jk")
                )
                      .collect(Collectors.toList())));

        results = new Results(new ArrayList<>(
                Stream.of(new Result("꽝"),
                          new Result("5000"),
                          new Result("꽝"),
                          new Result("3000")
                )
                      .collect(Collectors.toList())));

        gameInfo = new GameInfo(users, results);
    }

    @DisplayName("사다리 게임에 대한 전체 결과 값을 만든다.")
    @Test
    void GenerateResultsForAllPlayers() {
        resultView.printLadder(gameInfo, ladder);
        resultUsers = playLadderGame.generateResultsForAllPlayers(gameInfo, ladder);

        List<User> userList = resultUsers.getUsers();
        assertThat(userList.get(0).getResult()).isEqualTo("꽝");
        assertThat(userList.get(1).getResult()).isEqualTo("3000");
        assertThat(userList.get(2).getResult()).isEqualTo("꽝");
        assertThat(userList.get(3).getResult()).isEqualTo("5000");
    }
}

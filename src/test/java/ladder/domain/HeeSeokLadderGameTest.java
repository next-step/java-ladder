package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HeeSeokLadderGameTest {

    private Lines lines;
    private Users users;
    private static int countOfUser;

    @BeforeEach
    public void setUp() {
        users = new Users(Arrays.asList(new User(new Name("tom"))
                , new User(new Name("garry"))
                , new User(new Name("soyu"))
                , new User(new Name("jake"))));

        countOfUser = users.count();

        List<Line> lineList = new ArrayList<>();

        for (int i = 0; i < countOfUser; i++) {
            Line line = new Line(countOfUser);
            lineList.add(line);
        }
        lines = new Lines(lineList);
    }


    @Test
    @DisplayName("사다리 게임 한사람 결과 확인")
    public void gameResultTest() {

//        LadderGame ladderGame = new LadderGame(users, lines);
//
//        //users = ladderGame.start();
//        String[] inputResult = new String[]{"꽝","0","100","200"};
//        User tom = users.findByName("tom");
//        GameResult gameResult= new GameResult(inputResult);
//
//        tom = new User(tom.name(),0);
//
//        gameResult.show(tom.position());
//        assertThat(gameResult.show(tom.position())).isEqualTo("꽝");

    }

}

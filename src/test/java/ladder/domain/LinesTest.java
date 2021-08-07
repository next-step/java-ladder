package ladder.domain;

import ladder.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinesTest {
    private Line line;

    @Test
    @DisplayName("게임 결과 테스트")
    public void lineGameResultTest(){

        int ladderHeight = 3;

        List<User> userList =  Arrays.asList(new User("test"),new User("test2"),new User("test3"));
        Users users = new Users(userList);

        Ladder ladder = new Ladder(ladderHeight, userList.size());
        Lines lines = ladder.lines();

        OutputView outputView = new OutputView();

        for(Line line : lines){
            StringBuilder oneLadder = outputView.drawOneLine(line);
            System.out.print(oneLadder.toString());
        }
        int startPosition = 0;
        System.out.println("startPosition: " +startPosition);
        int result = lines.calulateGameResult(startPosition);
        System.out.println("result: " + result);

    }
}

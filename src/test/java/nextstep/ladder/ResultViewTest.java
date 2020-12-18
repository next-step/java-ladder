package nextstep.ladder;

import nextstep.ladder.model.Line;
import nextstep.ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ResultViewTest {

    @Test
    @DisplayName("출력 테스트")
    public void printTest(){
        List<Line> lines = new ArrayList<>();
        for(int i=0;i<5;i++){
            lines.add(new Line(4));
        }
        ResultView resultView = new ResultView();
        String[] people = {"kst","test","teste","pobi"};
        resultView.printLadder(people, 5, lines);


    }
}

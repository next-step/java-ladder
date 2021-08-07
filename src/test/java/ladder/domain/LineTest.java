package ladder.domain;

import ladder.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LineTest {
    private Line line;

    @Test
    @DisplayName("Height Line이 잘 그려지는지 확인")
    void drawHeightLine() {
        int countOfPerson = 3;
        line = new Line(countOfPerson);

        OutputView outputView = new OutputView();
        StringBuilder oneLadder = outputView.drawOneLine(line);
        System.out.println(oneLadder.toString());
    }

    @Test
    @DisplayName("Line Ladder 탐색")
    public void findRouteTest(){
        int countOfPerson = 3;
        line = new Line(countOfPerson);

        OutputView outputView = new OutputView();
        StringBuilder oneLadder = outputView.drawOneLine(line);
        System.out.println(oneLadder.toString());

        int startPosition = 0;
        System.out.println("startPosition: " +startPosition);
        int result = line.findRoute( startPosition);
        System.out.println(result);

    }

}

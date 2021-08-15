package ladder.domain;

import ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTests {

    @DisplayName("Ladder 생성 테스트")
    @Test
    void create(){
        List<String> participatePerson = new ArrayList<>(Arrays.asList("pobi","honux","crong","jk"));
        int ladderMaxLength = 5;
        int countOfPerson = participatePerson.size();

        Ladder ladder = Ladder.of(ladderMaxLength, countOfPerson);

        assertThat(ladder).isEqualTo(Ladder.of(5, 4));
    }

    @DisplayName("Ladder 의 높이, 폭 가져올 수 있는지 테스트")
    @Test
    void getLadderHeightWidthTest(){
        List<String> participatePerson = new ArrayList<>(Arrays.asList("pobi","honux","crong","jk"));
        int ladderMaxLength = 5;
        int countOfPerson = participatePerson.size();

        Ladder ladder = Ladder.of(ladderMaxLength, countOfPerson);

        ResultView.drawLadder(ladder);

        assertThat(ladder.getLadderHeight()).isEqualTo(5);
        assertThat(ladder.getLadderWidth()).isEqualTo(4);
    }


    @DisplayName("Ladder 그렸을때 옆에 붙어 있는 line 은 표시 안 되있는지 테스트")
    @Test
    void draw(){
        List<String> participatePerson = new ArrayList<>(Arrays.asList("pobi","honux","crong","jk"));
        int ladderMaxLength = 5;
        int countOfPerson = participatePerson.size();

        Ladder ladder = Ladder.of(ladderMaxLength, countOfPerson);

        ResultView.drawLadder(ladder);

        assertThat(ladder.isDraw(0 ,1)).isTrue();
        assertThat(ladder.isDraw(0 ,2)).isFalse();


    }
}

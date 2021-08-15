package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTests {

    @Test
    void create(){
        List<String> participatePerson = new ArrayList<>(Arrays.asList("pobi","honux","crong","jk"));
        int ladderMaxLength = 5;
        int countOfPerson = participatePerson.size();

        Ladder ladder = Ladder.of(countOfPerson, ladderMaxLength);

        assertThat(ladder).isEqualTo(Ladder.of(4, 5));
    }

//    @Test
//    void draw(){
//        List<String> participatePerson = new ArrayList<>(Arrays.asList("pobi","honux","crong","jk"));
//        int ladderMaxLength = 5;
//        int countOfPerson = participatePerson.size();
//
//        Ladder ladder = Ladder.of(countOfPerson, ladderMaxLength);
//
//        ResultView.draw(ladder);
//
//    }
}

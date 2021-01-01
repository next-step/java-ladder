package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    public void initTest(){
        Ladder ladder = new Ladder(3,4);

        assertThat(ladder.getLines().size()).isEqualTo(4);

    }


    @Test
    @DisplayName("리팩토링 사다리 생성 테스트")
    public void initTest2(){
        Ladder ladder = new Ladder(3,3);
        System.out.println(ladder.toString());


    }
}

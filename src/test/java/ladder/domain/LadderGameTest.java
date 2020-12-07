package ladder.domain;

import ladder.controller.LadderGameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {

    private LineBuildStrategy lineBuildStrategy;

    @BeforeEach
    public void init(){
        lineBuildStrategy = new RandomLineBuildStrategy();
    }


    @DisplayName("사다리 생성 테스트")
    @Test
    void ladderBuildTest(){
        // given
        int ladderMaxHeight = 5;

        //when
        Ladders ladders = new Ladders(IntStream.range(0, ladderMaxHeight)
                .mapToObj(ladder -> new Ladder(lineBuildStrategy.build(3)))
                .collect(Collectors.toList()));

        // then
        assertThat(ladders.getLadders().size()).isEqualTo(ladderMaxHeight);
    }

    @DisplayName("사다리 실행결과 테스트")
    @Test
    void ladderResultTest(){
        // given
        int ladderMaxHeight = 5;


        LadderBuildResult ladderBuildResult = LadderGameController.execute(new String[]{"aa","bb","dc"}, "5");

        Awards awards = new Awards(new String[]{"꽝","5000","1500"});

        LadderGameController.showBuildResult(ladderBuildResult, awards);

        Ladders ladders = ladderBuildResult.getLadders();


        int startLadderIndex = 0;
        int maxPoint = 2;
        int left = -1;
        int startPoint = 0;
        int right = 1;

        boolean results = true;
        while(startLadderIndex < ladderMaxHeight){
            System.out.println("=================결과");
            System.out.println("사다리 높이: "+ startLadderIndex+"  라인인덱스: "+startPoint);
            System.out.println(results);



            results = ladders.getLadders().get(startLadderIndex).getLine().getPoints().get(startPoint).getDirection().isRight();
        }

        // then
        assertThat(ladders.getLadders().size()).isEqualTo(ladderMaxHeight);
    }

    @DisplayName("사다리 최소 높이(1)보다 작은 경우 Exception Test")
    @ParameterizedTest
    @ValueSource(ints = {0, -2})
    void illegalPlayerNameExceptionTest(int maxHeight){

        assertThatIllegalArgumentException().isThrownBy(() -> {

            LadderGame ladderGame = new LadderGame(new RandomLineBuildStrategy());
            ladderGame.start(3, maxHeight);

        }).withMessageContaining(LadderGameErrorMessage.OVER_MIN_HEIGHT.getErrorMessage());
    }


}

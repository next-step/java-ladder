package ladder.view;

import ladder.domain.Result;
import ladder.domain.Rewards;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.People;
import ladder.util.LadderOutputConverter;


public class OutputView {

    public static void ladderCreateResult(People people, LadderLines ladderLines, Rewards rewards) {
        System.out.println("사다리 결과");
        System.out.println(LadderOutputConverter.peopleOutput(people));
        System.out.println(LadderOutputConverter.ladderLinesOutput(ladderLines));
        System.out.println(LadderOutputConverter.rewardsOutput(rewards));
    }

    public static void gameResult(Result result) {
        System.out.println("실행 결과");
        System.out.println(LadderOutputConverter.resultOutput(result));
    }
}

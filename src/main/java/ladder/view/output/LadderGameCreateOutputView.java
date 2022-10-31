package ladder.view.output;

import ladder.domain.Rewards;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.People;
import ladder.util.LadderOutputConverter;

import static ladder.util.LadderConst.*;

public class LadderGameCreateOutputView {

    public static void inputPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(" + PERSON_NAME_SEPARATOR + ")로 구분하세요)");
    }

    public static void inputPlayResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(" + INPUT_RESULT_SEPARATOR + ")로 구분하세요)");
    }

    public static void inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void result(People people, LadderLines ladderLines, Rewards rewards) {
        System.out.println("사다리 결과");
        System.out.println(LadderOutputConverter.peopleOutput(people));
        System.out.println(LadderOutputConverter.ladderLinesOutput(ladderLines));
        System.out.println(LadderOutputConverter.rewardsOutput(rewards));
    }
}

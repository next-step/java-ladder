package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.People;
import nextstep.ladder.domain.Peoples;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String REQUEST_PEOPLE_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String SPLIT = ",";
    Scanner scanner = new Scanner(System.in);
    public Peoples requestPeopleName() {
        System.out.println(REQUEST_PEOPLE_NAME);
        String names = scanner.nextLine();
        return split(names);
    }

    private Peoples split(String strings) {
        String[] splitStrings = strings.split(SPLIT);
        List<People> collect = Arrays.stream(splitStrings).map(People::new).collect(Collectors.toList());
        return new Peoples(collect);
    }

    public Ladder requestLadderHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT);
        String ladderHeight = scanner.nextLine();
        return convertLadder(ladderHeight);
    }

    private Ladder convertLadder(String ladderHeight) {
        return new Ladder(Integer.parseInt(ladderHeight));
    }
}

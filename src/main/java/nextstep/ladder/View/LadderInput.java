package nextstep.ladder.View;

import nextstep.ladder.Model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderInput {

    private static final String ASK_ATTEND_MEMBERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_MAX_HEIGHT = "최대 사다리 높이는 몇 개 인가요?";
    private static final String ASK_REWARDS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_RESULT_NAME = "결과를 보고 싶은 사람은?(모두 보고싶다면 all, 결과가 보기 싫을 때 stop)";
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static People askAttendMembers() {
        System.out.println(ASK_ATTEND_MEMBERS);
        List<Person> names = Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .map(Person::new)
                .collect(Collectors.toList());
        System.out.println(names.stream()
                .map(Person::toString)
                .collect(Collectors.joining(DELIMITER)));
        return new People(names);
    }

    public static Rewards askRewards() {
        System.out.println(ASK_REWARDS);
        List<Reward> rewards = Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .map(Reward::new)
                .collect(Collectors.toList());
        System.out.println(rewards.stream()
                .map(Reward::toString)
                .collect(Collectors.joining(DELIMITER)));
        return new Rewards(rewards);
    }

    public static Height askMaxHeight() {
        System.out.println(ASK_MAX_HEIGHT);
        int height = Integer.parseInt(SCANNER.nextLine());
        System.out.println(height);
        return new Height(height);
    }

    public static String askResultName() {
        System.out.println(ASK_RESULT_NAME);
        return SCANNER.nextLine();
    }
}

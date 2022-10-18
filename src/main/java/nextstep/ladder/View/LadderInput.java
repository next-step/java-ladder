package nextstep.ladder.View;

import nextstep.ladder.Model.Height;
import nextstep.ladder.Model.Name;
import nextstep.ladder.Model.Names;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderInput {

    private static final String ASK_ATTEND_MEMBERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_MAX_HEIGHT = "최대 사다리 높이는 몇 개 인가요?";
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Names askAttendMembers() {
        System.out.println(ASK_ATTEND_MEMBERS);
        List<Name> names = Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .map(Name::new)
                .collect(Collectors.toList());
        System.out.println(names.stream()
                .map(Name::toString)
                .collect(Collectors.joining(DELIMITER)));
        return new Names(names);
    }

    public static Height askMaxHeight() {
        System.out.println(ASK_MAX_HEIGHT);
        int height = Integer.parseInt(SCANNER.nextLine());
        System.out.println(height);
        return new Height(height);
    }
}

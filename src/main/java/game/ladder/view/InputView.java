package game.ladder.view;

import game.ladder.domain.*;
import game.ladder.util.Spliter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Participants readParticipant() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final List<Name> names = Spliter.split(scanner.nextLine()).stream().map(Name::new).collect(Collectors.toList());
        TreeSet<Participant> participants = IntStream.range(0, names.size())
                .mapToObj(i -> new Participant(names.get(i), new Position(i)))
                .collect(Collectors.toCollection(TreeSet::new));

        return new Participants(participants);
    }

    public static Height readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Height(Integer.parseInt(scanner.nextLine().trim()));
    }

    public static Expects readExpects() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        final List<Expect> expects = Spliter.split(scanner.nextLine()).stream().map(Expect::new).collect(Collectors.toList());
        return new Expects(expects);
    }

    public static Name readExpectParticipantName() {
        System.out.println("결과를 보고 싶은 사람은?");
        String name = scanner.nextLine();
        if (Name.ALL.isEqualValue(name)) {
            return Name.ALL;
        }
        return new Name(name);
    }
}

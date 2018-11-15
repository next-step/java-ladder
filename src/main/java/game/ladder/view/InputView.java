package game.ladder.view;

import game.ladder.domain.Participant;
import game.ladder.domain.Position;
import game.ladder.util.Spliter;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Participant> readParticipant() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final List<String> names = Spliter.split(scanner.nextLine());

        return IntStream.range(0, names.size())
                    .mapToObj(i -> new Participant(names.get(i), new Position(i + 1)))
                    .collect(Collectors.toList());
    }

}

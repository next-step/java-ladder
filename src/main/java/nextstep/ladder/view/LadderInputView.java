package nextstep.ladder.view;

import nextstep.ladder.model.Height;
import nextstep.ladder.model.Name;
import nextstep.ladder.model.People;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderInputView {
    Scanner scanner = new Scanner(System.in);

    public People getPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return new People(Arrays.stream(scanner.nextLine().split(","))
                .map(Name::new)
                .collect(Collectors.toList()));
    }

    public Height getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Height(scanner.nextInt());
    }
}

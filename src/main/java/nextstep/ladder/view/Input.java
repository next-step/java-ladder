package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

    private static final Scanner input = new Scanner(System.in);

    public List<String> joinPerson() {
        print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] persons = input.nextLine().split(",");
        System.out.println();
        return Arrays.stream(persons)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int ladderHeight() {
        print("최대 사다리 높이는 몇 개인가요?");
        return input.nextInt();
    }

    public List<String> runResult() {
        print("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        String[] result = input.nextLine().split(",");
        System.out.println();
        List<String> run = Arrays.stream(result)
                .map(String::trim)
                .collect(Collectors.toList());
        print("");
        return run;
    }

    public String resultWantPerson() {
        print("결과를 보고 싶은 사람은?");
        return input.next();
    }

    private void print(String word) {
        System.out.println(word);
    }
}

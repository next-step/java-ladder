package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView implements Input {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public List<String> readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(scanner.nextLine().split(",")).map(String::trim).collect(Collectors.toList());
    }

    @Override
    public List<String> readResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Arrays.stream(scanner.nextLine().split(",")).map(String::trim).collect(Collectors.toList());
    }

    @Override
    public int readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String askPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine().trim();
    }
}


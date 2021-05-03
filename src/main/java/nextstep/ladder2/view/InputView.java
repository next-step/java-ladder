package nextstep.ladder2.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final List<String> inputs;

    public InputView() {
        inputs = new ArrayList<>();
    }

    public void getInfoFromClient() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        inputs.add(scanner.nextLine());

        System.out.println("실행 결과를 입력하세요. (결과를 쉼표(,)로 구분하세요)");
        inputs.add(scanner.nextLine());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        inputs.add(scanner.nextLine());
    }

    public List<String> getPlayersName() {
        return Arrays.asList(inputs.get(0).split(","));
    }

    public List<String> getPrizesName() {
        return Arrays.asList(inputs.get(1).split(","));
    }

    public int getLadderHeight() {
        return Integer.parseInt(inputs.get(2));
    }


    public String getPlayerResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}

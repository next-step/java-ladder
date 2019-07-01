package nextstep.step2.ui;

import java.util.List;
import java.util.Scanner;

import nextstep.step2.dto.PlayersDTO;
import nextstep.step2.dto.GameResultDTO;

public class InputView {

    public static PlayersDTO inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new PlayersDTO(List.of(scanner.next().split(",")));
    }

    public static GameResultDTO inputResult() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new GameResultDTO(List.of(scanner.next().split(",")));
    }

    public static int inputLadderHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

}

package nextstep.ladder.view;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private PrintWriter output;

    public InputView(Scanner scanner, PrintWriter output) {
        this.scanner = scanner;
        this.output = output;
    }

    public List<String> getMemberNames() {
        output.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public int getLadderHeight() {
        output.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}

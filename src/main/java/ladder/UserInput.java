package ladder;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserInput {

    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String readLadderMemberNames() {
        return getStringFromStdin("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public int readLadderHeight() {
        return getNumberFromStdin("최대 사다리 높이는 몇 개인가요?");
    }

    private String getStringFromStdin(String displayText) {
        System.out.println(displayText);
        return scanner.nextLine();
    }

    private int getNumberFromStdin(String displayText) {
        System.out.println(displayText);
        return Integer.valueOf(scanner.nextLine());
    }

    @Override
    protected void finalize() throws Throwable {
        this.scanner.close();
        super.finalize();
    }

}

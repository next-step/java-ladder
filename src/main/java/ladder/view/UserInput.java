package ladder.view;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String readLadderMemberNames() {
        return getStringFromStdin("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public String readLadderResults() {
        return getStringFromStdin("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public int readLadderHeight() {
        return getNumberFromStdin("최대 사다리 높이는 몇 개인가요?");
    }

    public String readMemberNameForResult() {
        return getStringFromStdin("결과를 보고 싶은 사람은?");
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

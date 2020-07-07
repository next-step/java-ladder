package ladder.view;

import java.util.Scanner;

public class LadderInputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final String gameAttendees;
    private final String ladderCompensation;
    private final int ladderHeight;

    private LadderInputView(String gameAttendees, String ladderCompensation, int ladderHeight) {
        this.gameAttendees = gameAttendees;
        this.ladderCompensation = ladderCompensation;
        this.ladderHeight = ladderHeight;
    }

    public static LadderInputView enterLadderInput() {
        return new LadderInputView(enterGameAttendees(), enterLadderCompensation(), enterLadderHeight());
    }

    private static String enterGameAttendees() {
        System.out.println("참여할 사람의 이름을 입력 하세요. (이름은 쉽표(,)로 구분 하세요.)");
        return SCANNER.nextLine();
    }

    private static int enterLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return SCANNER.nextInt();
    }

    private static String enterLadderCompensation() {
        System.out.println("실행 결과를 입력 하세요.(결과는 쉼표(,)로 구분 하세요");
        return SCANNER.nextLine();
    }

    public String getGameAttendees() {
        return gameAttendees;
    }

    public String getLadderCompensation() {
        return ladderCompensation;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

}

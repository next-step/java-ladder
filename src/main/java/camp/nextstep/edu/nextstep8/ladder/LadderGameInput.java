package camp.nextstep.edu.nextstep8.ladder;

import java.util.Scanner;

public class LadderGameInput {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요");
        if(SCANNER.hasNextInt()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("최대 사다리 높이를 숫자로 정확히 입력해 주세요");
    }

    public static String getJoinMembers() {
        System.out.println("참여할 사람 이름을 입력하세요 (최대 5글자, 쉼표(,)로 구분)");
        if(SCANNER.hasNextLine()) {
            return SCANNER.next().trim();
        }
        throw new IllegalArgumentException("입력된 값이 없습니다");
    }
}

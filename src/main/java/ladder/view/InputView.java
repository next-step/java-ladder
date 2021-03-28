package ladder.view;

import java.util.Scanner;
public class InputView {
    private static final String INPUT_PERSON_GUIDANCE_PHRASES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_SIZE_GUIDANCE_PHRASES = "최대 사다리 높이는 몇 개인가요?";

    private static Scanner scanner = new Scanner(System.in);

    public String person() {
        System.out.println(INPUT_PERSON_GUIDANCE_PHRASES);
        return scanner.nextLine();
    }

    public int ladderSize() {
        System.out.println(INPUT_LADDER_SIZE_GUIDANCE_PHRASES);
        return scanner.nextInt();
    }
}

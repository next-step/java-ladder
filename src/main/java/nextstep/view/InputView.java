package nextstep.view;

import java.util.Scanner;

public class InputView {

    private static final int MIN_LADDER_HEIGHT  = 1;
    private static final int MIN_NAME_LENGTH    = 2;

    private static final Scanner scanner = new Scanner(System.in);


    public static String[] inputNames(){

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String[] names = scanner.next().split(",");

        if(names.length < MIN_NAME_LENGTH){
            throw new IllegalArgumentException("최소 2명 이상이어야 합니다.");
        }

        return names;
    }

    public static int inputLadderHeight() {

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = scanner.nextInt();

        if(ladderHeight < MIN_LADDER_HEIGHT){
            throw new IllegalArgumentException("높이는 1 이상이여야 합니다.");
        }
        return ladderHeight;
    }
}

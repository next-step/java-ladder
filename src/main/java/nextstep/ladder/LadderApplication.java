package nextstep.ladder;

import java.util.Arrays;
import java.util.Scanner;

public class LadderApplication {
    private static final String REQUEST_MEMBER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_MAX_LADDER_LENGTH = "최대 사다리 높이는 몇 개인가요?";

    private static final String RESPONSE_INIT_MESSAGE = "실행결과";
    private static final String RESPONSE_MEMBER_MESSAGE = "%s ";

    private static final String DEFAULT_WHITE_SPACE_CHARACTER = " ";
    private static final String DEFAULT_CHARACTER = "";
    private static final String DEFAULT_SPLIT_CHARACTER = ",";

    private static final String NOT_LINKED_TEXT = "    |";
    private static final String LINKED_TEXT = "-----|";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(REQUEST_MEMBER_NAME_MESSAGE);
        String memberNames = scanner.next();
        String[] members = memberNames.replaceAll(DEFAULT_WHITE_SPACE_CHARACTER, DEFAULT_CHARACTER)
                                        .split(DEFAULT_SPLIT_CHARACTER);

        System.out.println();
        System.out.println(REQUEST_MAX_LADDER_LENGTH);
        int ladderHeight = scanner.nextInt();

        System.out.println();
        System.out.println(RESPONSE_INIT_MESSAGE);

        System.out.println();
        Arrays.stream(members)
                    .map(m -> leftLad(m) + DEFAULT_WHITE_SPACE_CHARACTER)
                    .forEach(System.out::print);
        System.out.println();
        // 5글자까지 채우기 없으면 공백으로
        // 이름 이후 한칸 공백 추가
        // optional 해서 이전께 없으면 null 빈칸
        // 있으면 라인 or 빈칸
        // 이전 array의 현위치건이 빈칸이면 라인 or 빈칸
        // 이전 array의 현위치건이 있으면 빈칸
        for(int i=0; i < ladderHeight; i++) {
            for(int j=0; j < members.length; j++) {
                if (j == 0) {
                    System.out.print(NOT_LINKED_TEXT);
                }else{
                    System.out.print(LINKED_TEXT);
                }
            }
            System.out.println();
        }

    }

    private static String leftLad(String text) {
        return String.format("%5s", text);
    }
}

package ladder.view;

public class OutputView {

    private static final int PERSON_NAME_LENGTH_MAX = 5;

    public static void inputPersonName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static String outputPersonName(String name) {
        return String.format("%-" + PERSON_NAME_LENGTH_MAX + "s", name);
    }
}

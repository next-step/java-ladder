package ladder.view.output;

public class LadderGameResultOutputView {

    public static void inputResultPersonName() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public static void resultGuide() {
        System.out.println("실행 결과");
    }

    public static void inputResultPersonNameException() {
        System.out.println("결과를 보고 싶은 사람 이름 입력이 잘못됐습니다 다시 입력해주세요");
    }

    public static void result(String result) {
        resultGuide();
        System.out.println(result);
    }
}

package device;

import java.util.Scanner;

public class InputDevice {

    public static String inputNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public static String inputResults() {
        Scanner sc = new Scanner(System.in);
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public static int inputHeight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public static String knowResult() {
        Scanner sc = new Scanner(System.in);
        System.out.println("결과를 보고 싶은 사람은?");
        return sc.nextLine();
    }

    public static String inputDifficult() {
        Scanner sc = new Scanner(System.in);
        System.out.println("실행할 사다리의 난이도는?");
        return sc.nextLine().trim();
    }

}

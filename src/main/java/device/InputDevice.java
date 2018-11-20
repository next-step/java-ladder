//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

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
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return sc.nextInt();
    }

    public static void ladderResult() {
        System.out.println("사다리 결과");
    }

    public static String knowResult() {
        Scanner sc = new Scanner(System.in);
        System.out.println("결과를 보고 싶은 사람은?");
        return sc.nextLine();
    }

    public static void runResult() {
        System.out.println("실행 결과");
    }
}

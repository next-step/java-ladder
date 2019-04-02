package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputView {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String inputPlayerNames() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = reader.readLine();
        System.out.println();

        return names;
    }

    public static String inputRunResults() throws IOException {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String runResults = reader.readLine();
        System.out.println();

        return runResults;
    }

    public static String inputLevel() throws IOException {
        System.out.println("실행할 사다리의 난이도는?");
        String result = reader.readLine();
        System.out.println();

        return result;
    }

    public static String inputWantSeeResult() throws IOException {
        System.out.println("결과를 보고 싶은 사람은?");
        String result = reader.readLine();
        System.out.println();

        return result;
    }
}

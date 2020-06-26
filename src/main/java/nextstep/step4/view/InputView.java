package nextstep.step4.view;

import nextstep.step4.resource.LadderStringResource;
import nextstep.step4.utils.LadderUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> getUserNames() {
        System.out.println(LadderStringResource.GET_USER_MSG);
        return LadderUtils.splitString(scanner.nextLine());
    }

    public static int getLadderHeight() {
        System.out.println(LadderStringResource.GET_LADDER_HEIGHT_MSG);
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public static List<String> getPlayResult() {
        System.out.println(LadderStringResource.GET_PLAY_RESULT_MSG);
        return LadderUtils.splitString(scanner.nextLine());
    }

    public static String getUserNameForResult() {
        System.out.println();
        System.out.println(LadderStringResource.GET_USER_NAME_FOR_RESULT);
        return scanner.nextLine();
    }
}

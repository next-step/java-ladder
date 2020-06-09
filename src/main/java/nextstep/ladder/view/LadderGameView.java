package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.MountingBlock;
import nextstep.ladder.domain.Player;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;

public class LadderGameView {

    private static final String USER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String SHAPE_OF_HEIGHT = "|";
    private static final String SHAPE_OF_MOUNTING_BLOCK = "-----";
    private static final String BLANK_MOUNTING_BLOCK = "     ";
    private static final Integer FIRST_HEIGHT_PADDING_VALUE = 6;

    public static List<String> inputUserNames() {
        System.out.println(USER_NAME_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String userNameInput = scanner.nextLine();
        return LadderGameViewHelper.parseUserNameInput(userNameInput);
    }

    public static Integer inputLadderHeight() {
        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void viewLadderShape(List<Player> players, List<Line> lines) {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        System.out.println();
        viewPlayers(players);
        viewLadder(lines);
    }

    private static void viewPlayers(List<Player> players) {
        for (Player player : players) {
            String leftPad = player.convertUserNameWithLeftPad();
            System.out.print(leftPad);
        }
        System.out.println();
    }

    private static void viewLadder(List<Line> lines) {
        for (Line line : lines) {
            line.viewLine();
        }
    }

    public static void viewLine(List<MountingBlock> mountingBlocks) {
        drawFirstHeight();
        for (MountingBlock mountingBlock : mountingBlocks) {
            drawMountingBlock(mountingBlock.getMountingBlock());
            System.out.print(SHAPE_OF_HEIGHT);
        }

        System.out.println();
    }

    private static void drawFirstHeight() {
        System.out.print(StringUtils.leftPad(SHAPE_OF_HEIGHT, FIRST_HEIGHT_PADDING_VALUE));
    }

    private static void drawMountingBlock(Boolean mountingBlock) {
        if (mountingBlock) {
            System.out.print(SHAPE_OF_MOUNTING_BLOCK);
            return;
        }

        System.out.print(BLANK_MOUNTING_BLOCK);
    }
}

package nextstep.ladder.view;

import nextstep.ladder.constant.LadderConstants;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.MountingBlock;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;

public class LadderGameView {

    public static List<String> inputUserNames() {
        System.out.println(LadderConstants.USER_NAME_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String userNameInput = scanner.nextLine();
        return LadderGameViewHelper.parseInputWithComma(userNameInput);
    }

    public static List<String> inputExecutionResults() {
        System.out.println(LadderConstants.EXECUTION_RESULT_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String executionResult = scanner.nextLine();
        return LadderGameViewHelper.parseInputWithComma(executionResult);
    }

    public static Integer inputLadderHeight() {
        System.out.println(LadderConstants.LADDER_HEIGHT_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void viewLadderShape(Ladder ladder) {
        System.out.println(LadderConstants.EXECUTION_RESULT_MESSAGE);
        System.out.println();

        Players players = ladder.getPlayers();
        viewPlayers(players);
        Lines lines = ladder.getLines();
        viewLadder(lines);
    }

    private static void viewPlayers(Players players) {
        for (Player player : players.getPlayers()) {
            String leftPad = player.convertUserNameWithLeftPad();
            System.out.print(leftPad);
        }
        System.out.println();
    }

    private static void viewLadder(Lines lines) {
        for (Line line : lines.getLines()) {
            viewLine(line.getMountingBlocks());
        }
    }

    public static void viewLine(List<MountingBlock> mountingBlocks) {
        drawFirstHeight();
        for (MountingBlock mountingBlock : mountingBlocks) {
            drawMountingBlock(mountingBlock.getMountingBlock());
            System.out.print(LadderConstants.SHAPE_OF_HEIGHT);
        }

        System.out.println();
    }

    private static void drawFirstHeight() {
        System.out.print(StringUtils.leftPad(LadderConstants.SHAPE_OF_HEIGHT, LadderConstants.FIRST_HEIGHT_PADDING_VALUE));
    }

    private static void drawMountingBlock(Boolean mountingBlock) {
        if (mountingBlock) {
            System.out.print(LadderConstants.SHAPE_OF_MOUNTING_BLOCK);
            return;
        }

        System.out.print(LadderConstants.BLANK_MOUNTING_BLOCK);
    }
}

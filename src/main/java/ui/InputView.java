package ui;

import domain.Participants;
import domain.Rewards;
import dto.InputDto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INSERT_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INSERT_REWARDS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INSERT_HEIGHT_OF_LADDER = "최대 사다리 높이는 몇 개인가요?";
    private static final String INSERT_NAME = "결과를 보고 싶은 사람은?";

    private InputView() {}

    public static InputDto askInput() {
        InputDto inputDto = new InputDto();

        System.out.println(INSERT_PARTICIPANTS);
        inputDto.setParticipants(Participants.of(scanner.nextLine()));
        System.out.println(INSERT_REWARDS);
        inputDto.setRewards(Rewards.of(scanner.nextLine()));
        System.out.println(INSERT_HEIGHT_OF_LADDER);
        inputDto.setLadderHeight(Integer.parseInt(scanner.nextLine()));

        return inputDto;
    }

    public static String askResultOf() {
        System.out.println(INSERT_NAME);
        return scanner.nextLine();
    }
}

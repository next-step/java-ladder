package ladder.view;

import ladder.dto.UserStatusDto;

import java.util.List;

public class OutputView {

    private static String CREATE_MAP_RESULT_INFOMATION = "사다리 결과";
    private static String RESULT_INFOMATION = "실행 결과";
    private static int PADDING_LENGTH = 5;

    private OutputView() {
    }

    public static OutputView of() {
        return new OutputView();
    }

    public void printLadderResult(List<String> climberNames, List<List<Boolean>> ladderMap, List<String> rewards) {
        printUsersName(climberNames);
        printLadderMap(ladderMap);
        printReward(rewards);
    }

    private void printUsersName(List<String> climberNames) {
        System.out.println(CREATE_MAP_RESULT_INFOMATION);
        climberNames.forEach(climberName -> {
            System.out.print(lpadString(climberName, PADDING_LENGTH, " ") + " ");
        });
        System.out.println();
    }

    private String lpadString(String text, int length, String alternate) {
        if(text.length() - length >= 0) {
            return text;
        }

        StringBuilder lpadString = new StringBuilder(text);
        int alternateLength = length - text.length();
        for (int i = 0; i < alternateLength; i++) {
            lpadString.insert(0, alternate);
        }
        return lpadString.toString();
    }

    private void printLadderMap(List<List<Boolean>> ladderMap) {
        ladderMap.forEach(line -> {
            System.out.print("    |");
            line.stream().forEach(cross -> {
                System.out.print(ladderGap(cross));;
            });
            System.out.println();
        });
    }

    private String ladderGap(boolean crossLoad) {
        if (crossLoad) {
           return "----|";
        }
        return "    |";
    }

    private void printReward(List<String> rewards) {
        rewards.forEach(reward -> {
            System.out.print(lpadString(reward, PADDING_LENGTH, " ") + " ");
        });
        System.out.println();
    }

    public void resultEachUser(UserStatusDto userStatusDto) {
        System.out.println(RESULT_INFOMATION);
        System.out.println(userStatusDto.getPrize());
        System.out.println();
    }

    public void resultAllUser(List<UserStatusDto> userStatusDtos) {
        System.out.println(RESULT_INFOMATION);
        userStatusDtos.forEach(userStatusDto -> {
            System.out.println(userStatusDto.getName() + " : " + userStatusDto.getPrize());
        });
    }
}

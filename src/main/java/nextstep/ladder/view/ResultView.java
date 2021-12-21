package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class ResultView {
    private static final String RESPONSE_INIT_MESSAGE = "사다리 결과";
    private static final String RESPONSE_RESULT_MESSAGE = "실행 결과";
    private static final String RESPONSE_RIGHT_ALIGN_MESSAGE = "%5s ";
    private static final String SPLIT_MEMBER_REWARD = " : ";
    private static final String NOT_LINKED_LINE = "     |";
    private static final String LINKED_LINE = "-----|";
    private static final String ALL_MEMBERS = "all";

    public static void responseInitMessage() {
        System.out.println();
        System.out.println(RESPONSE_INIT_MESSAGE);
    }

    public static void responseLadderMembers(Members members) {
        System.out.println();
        members.getMembers().stream()
                    .map(member -> rightAlignment(member.getName()))
                    .forEach(System.out::print);
    }

    private static String rightAlignment(String text) {
        return String.format(RESPONSE_RIGHT_ALIGN_MESSAGE, text);
    }

//    public static void responseLadder(Ladder ladder) {
//        System.out.println();
//        for (LadderLine line : ladder.getLines()) {
//            printLine(line);
//        }
//    }
//
//    private static void printLine(LadderLine ladderLine) {
//        for (Point point : ladderLine.getPoints()) {
//            System.out.print(checkLine(point));
//        }
//        System.out.println();
//    }
//
//    private static String checkLine(Point point) {
//        if (point.last()) {
//            return LINKED_LINE;
//        }
//        return NOT_LINKED_LINE;
//    }
//
//    public static void responseRewards(Rewards rewards) {
//        rewards.getRewards().stream()
//                .map(reward -> rightAlignment(reward.getReward()))
//                .forEach(System.out::print);
//    }
//
//    public static void responseResults(String member, LadderResults ladderResults) {
//        System.out.println();
//        System.out.println(RESPONSE_RESULT_MESSAGE);
//
//        if (member.equals(ALL_MEMBERS)) {
//            responseResultAll(ladderResults);
//            return;
//        }
//        System.out.println(ladderResults.getResult(member));
//    }
//
//    private static void responseResultAll(LadderResults ladderResults) {
//        ladderResults.getResults()
//                        .stream()
//                        .map(ladderResult -> ladderResult.getMemberName() + SPLIT_MEMBER_REWARD + ladderResult.getReward())
//                        .forEach(System.out::println);
//    }
}

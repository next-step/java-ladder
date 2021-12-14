package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.*;
import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.result.ResultCollection;
import nextstep.ladder.domain.user.Name;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.UserCollection;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String HORIZON = "─";
    private static final String BLANK = " ";
    private static final int TEXT_WIDTH = 5;

    private OutputView() {
    }

    public static void drawLadderGame(UserCollection users, Ladder ladder, ResultCollection resultCollection) {
        System.out.println("사다리 결과");
        drawUserName(users);
        drawLadder(ladder);
        drawResult(resultCollection);
    }

    private static void drawUserName(UserCollection users) {
        String userNameFormat = users.getUsers()
                .stream()
                .map(User::getName)
                .map(Name::getValue)
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining());
        System.out.println(userNameFormat);
    }

    private static void drawResult(ResultCollection results) {
        String userNameFormat = results.getUsers()
                .stream()
                .map(Result::getValue)
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining());
        System.out.println(userNameFormat);
    }

    private static void drawLadder(Ladder ladder) {
        ladder.getLadderLines()
                .stream()
                .map(OutputView::ladderLineFormat)
                .forEach(System.out::println);
    }

    private static String ladderLineFormat(LadderLine ladderLine) {
        return ladderLine.getPoints()
                .stream()
                .map(Point::getDirection)
                .map(OutputView::pointLineFormat)
                .collect(Collectors.joining());
    }

    private static String pointLineFormat(Direction direction) {
        if (Direction.LEFT == direction) {
            return new String(new char[TEXT_WIDTH]).replace("\0", HORIZON) + direction.getShape();
        }
        return new String(new char[TEXT_WIDTH]).replace("\0", BLANK) + direction.getShape();
    }

    public static void showLadderResult(LadderResult result) throws ArrayIndexOutOfBoundsException {
        System.out.println("실행 결과");
        System.out.println(result.getResult().getValue());
    }

    public static void showLadderResult(List<LadderResult> ladderResults) throws ArrayIndexOutOfBoundsException{
            System.out.println("실행 결과");
            ladderResults.stream()
                    .map(ladderResult -> ladderResult.getUser().getName().getValue() + " : " + ladderResult.getResult().getValue())
                    .forEach(System.out::println);
    }

    public static void wrongUserCheck(){
        System.out.println("잘못된 유저 이름입니다 다시 입력해주세요");
    }
}

package nextstep.ladder.domain;


import nextstep.ladder.dto.LadderGameDto;
import nextstep.ladder.dto.PointDto;
import nextstep.ladder.dto.ResultInput;
import nextstep.ladder.dto.UserDto;

import java.util.List;

public class ResultView {
    private static final String COLUMN = "|";
    private static final String LINE = "_____";
    private static final String EMPTY_LINE = "     ";

    public void printLadder(List<UserDto> userDtos, List<List<PointDto>> ladder, List<String> results) {
        for (UserDto user : userDtos) {
            System.out.print(user.getName() + EMPTY_LINE);
        }
        System.out.println("");
        for (List<PointDto> points : ladder) {
            printRow(points);
            System.out.println("");
        }
        for (String result : results) {
            System.out.print(result + EMPTY_LINE);
        }
    }

    public void printResult(ResultInput resultInput, LadderGameDto ladderGame) {
        System.out.println("실행결과");
        System.out.println(getResult(resultInput, ladderGame));
    }

    public String getResult(ResultInput resultInput, LadderGameDto ladderGame) {
        String result = "";
        if (resultInput.isAll()) {
            for (UserDto user : ladderGame.getUserDtos()) {
                result += user.getName() + " : " + user.getResult() + "\n";
            }
            return result;
        }
        return resultInput.getName() + " : " + ladderGame.findResultByUserName(resultInput.getName());
    }

    public void printRow(List<PointDto> points) {
        for (PointDto point : points) {
            System.out.print(COLUMN);
            System.out.print(getLine(point));
        }
    }

    public String getLine(PointDto point) {
        if (point.isRight()) {
            return LINE;
        }
        return EMPTY_LINE;
    }
}

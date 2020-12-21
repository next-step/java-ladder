package nextstep.laddergame.view;

import nextstep.laddergame.domain.Gift;
import nextstep.laddergame.domain.Person;
import nextstep.laddergame.domain.Point;
import nextstep.laddergame.domain.dto.LadderDTO;
import nextstep.laddergame.domain.dto.LineDTO;
import nextstep.laddergame.domain.dto.ResultDTO;
import org.apache.commons.lang3.StringUtils;


import java.util.List;

public class ResultView {

    private static final String WAY = "|-----";
    private static final String NOT_WAY = "|     ";

    public void showPeople(List<Person> people) {
        for (Person person : people) {
            System.out.print(" " + StringUtils.center(person.getName(), 5));

        }
        System.out.println();
    }

    public void showLadder(LadderDTO ladder) {
        for (LineDTO line : ladder.getLines()) {
            System.out.print("   ");
            printLine(line);
            System.out.println();
        }
    }

    private void printLine(LineDTO line) {
        for (int index = 0; index < line.getPoints().size(); index++) {
            showWay(line.getPoints().get(index));
        }
    }

    private void showWay(Point point) {
        if (point.getDirection().isRight()){
            System.out.print(WAY);
        }

        if (point.getDirection().isNotMove()) {
            System.out.print(NOT_WAY);
        }

        if (point.getDirection().isLeft()) {
            System.out.print(NOT_WAY);
        }

    }

    public void showResult(ResultDTO result) {
        System.out.println("실행 결과");
        System.out.println(result.getName() + " : " + result.getGift());
    }

    public void showAllResult(List<ResultDTO> allResult) {
        System.out.println("실행 결과");
        for (ResultDTO resultDTO : allResult) {
            System.out.println(resultDTO.getName() + " : " + resultDTO.getGift());
        }

    }

    public void showGift(List<Gift> gifts) {
        for (Gift gift : gifts) {
            System.out.print(" " + StringUtils.center(gift.getName(), 5));
        }
        System.out.println();

    }
}

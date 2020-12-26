package nextstep.laddergame.view;

import nextstep.laddergame.domain.Gift;
import nextstep.laddergame.domain.Person;
import nextstep.laddergame.domain.Point;
import nextstep.laddergame.domain.dto.LadderDTO;
import nextstep.laddergame.domain.dto.LineDTO;
import nextstep.laddergame.domain.dto.ResultDTO;

import java.util.List;

public class ResultView {
    private static final String WAY = "|-----";
    private static final String NOT_WAY = "|     ";

    public void showPeople(List<Person> people) {
        for (Person person : people) {
            System.out.print(" " + setStringSize(person.getName()));
        }
        System.out.println();
    }

    private String setStringSize(String name) {
        while (name.length() < 5) {
            name = addLeftSpace(name);

            if (name.length() == 5) {
                break;
            }

            name = addRightSpace(name);
        }
        return name;
    }

    private String addRightSpace(String name) {
        return name + " ";
    }

    private String addLeftSpace(String name) {
        return " " + name;
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
        if (point.canRight()){
            System.out.print(WAY);
        }
        if (point.canLeft()) {
            System.out.print(NOT_WAY);
        }
        if (point.canNotMove()) {
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
            System.out.print(" " + setStringSize(gift.getName()));
        }
        System.out.println();
    }
}

package step2.uiView;


import step2.enums.ResultMessage;
import step2.model.Ladder;
import step2.model.LadderPrize;
import step2.model.Person;

import java.util.stream.Collectors;

public class ResultView {

    //사다리게임을 출력한다.
    public void resultLadderGame(Person person, Ladder ladder, LadderPrize ladderPrize) {
        System.out.println(ResultMessage.RESULT.message());
        // 참가자 출력
        String personList = person.getNames().stream()
                .map(name -> String.format("%6s", name.getName()))
                .collect(Collectors.joining(""));

        System.out.println(personList);

        // 사다리 출력
        ladder.getLine().forEach(line -> {
            line.getPoints().forEach(point -> System.out.print(point ? ResultMessage.CREATE_LADDER.message() : ResultMessage.NO_LADDER.message()));
            System.out.println();
        });

        // 사다리게임 보상 출력
        String ladderPrizeList = ladderPrize.getPrizes().stream()
                .map(prize -> String.format("%6s", prize.getPrize()))
                .collect(Collectors.joining(""));

        System.out.println(ladderPrizeList);
    }

    public void resultLadderPrize(LadderPrize ladderPrize, Person person, int[] endGameIndex) {
        System.out.println(ResultMessage.RESULT.message());
        for(int i = 0; i < person.nameSize(); i++) {
            System.out.println(person.getNames().get(i).getName() + ":" + ladderPrize.choosePrize(endGameIndex[i]).getPrize());
        }
    }

}

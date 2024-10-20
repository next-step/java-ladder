package step2.uiView;


import step2.enums.ResultMessage;
import step2.model.Ladder;

import java.util.stream.Collectors;

public class ResultView {

    //사다리를 출력한다.
    public void resultLadder(Ladder ladder) {
        System.out.println(ResultMessage.RESULT.message());
        // 참가자 출력
        String person = ladder.getPerson().getNames().stream()
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining(""));

        System.out.println(person);

        // 사다리 출력
        ladder.getLine().forEach(line -> {
            line.getPoints().forEach(point -> System.out.print(point ? ResultMessage.CREATE_LADDER.message() : ResultMessage.NO_LADDER.message()));
            System.out.println();
        });
    }

}

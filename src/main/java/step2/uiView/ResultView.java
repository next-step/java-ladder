package step2.uiView;


import step2.enums.ResultMessage;
import step2.model.Ladder;

public class ResultView {

    private final static String BLANK = "   ";

    //사다리를 출력한다.
    public void resultLadder(Ladder ladder) {
        System.out.println(ResultMessage.RESULT.message());
        // 참가자 출력
        System.out.println(String.join(BLANK, ladder.getPerson()));

        // 사다리 출력
        ladder.getLine().forEach(line -> {
            line.getPoints().forEach(point -> System.out.print(point ? ResultMessage.CREATE_LADDER.message() : ResultMessage.NO_LADDER.message()));
            System.out.println();
        });
    }

}

package ladder.view;

import ladder.controller.response.ResultDto;

public class GameResultView {
    private static final String RESULT_FORMAT = "\n실행 결과";
    private static final String PERSON_RESULT_VALUE_FORMAT = "%s : %s";

    public static void printGameResult(ResultDto resultDto) {
        System.out.println(RESULT_FORMAT);

        if (resultDto.isSingleResult()) {
            printSingleGameResult(resultDto);
            return;
        }

        for (String name : resultDto.getNames()) {
            System.out.println(String.format(PERSON_RESULT_VALUE_FORMAT, name, resultDto.getResultValue(name)));
        }
    }

    private static void printSingleGameResult(ResultDto resultDto) {
        System.out.println(resultDto.getSingleResult());
    }
}

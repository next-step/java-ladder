package ladder.view.printable;

import ladder.dto.ResultDto;

public class ResultPrintable extends Printable {
    private final ResultDto dto;

    public ResultPrintable(ResultDto resultDto) {
        dto = resultDto;
    }

    @Override
    public void print() {
        println(System.lineSeparator() + "실행 결과");
        println(dto.getResult());
    }
}

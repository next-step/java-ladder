package ladder.view.printable;

import ladder.dto.response.LadderDto;

public class LadderPrintable extends Printable {
    private final LadderDto dto;

    public LadderPrintable(final LadderDto ladderDto) {
        dto = ladderDto;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("실행결과");
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append(dto.getPlayers());
        println(sb);
    }
}


package ladder.view.printable;

import ladder.dto.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ladder.asset.LadderConst.STANDARD_LENGTH;

public class LadderPrintable extends Printable {
    private final LadderDto dto;

    public LadderPrintable(final LadderDto ladderDto) {
        dto = ladderDto;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("사다리 결과");
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append(toString(dto.getPersons()));
        sb.append(toString(dto.getLines()));
        sb.append(System.lineSeparator());
        sb.append(toString(dto.getResults()));
        println(sb);
    }

    private String toString(LinesDto dto) {
        return dto.getLines().stream()
                .map(this::toString)
                .map(line -> System.lineSeparator() + line)
                .reduce("", String::concat);
    }

    private String toString(LineDto dto) {
        return dto.getPoints().stream()
                .map(this::toString)
                .reduce("", String::concat);
    }

    private String toString(PointDto dto) {
        return dto.getIsLeft()
                ? "-----|"
                : "     |";
    }

    private String toString(PersonsDto dto) {
        return dto.getPersons().stream()
                .map(PersonDto::getName)
                .map(this::addWhiteSpaces)
                .reduce("", String::concat);
    }

    private String toString(ResultsDto dto) {
        return dto.getResults().stream()
                .map(ResultDto::getResult)
                .map(this::addWhiteSpaces)
                .reduce("", String::concat);
    }

    private String addWhiteSpaces(String str) {
        String whitespaces = Stream.generate(() -> " ")
                .limit(STANDARD_LENGTH - str.length() + 1)
                .collect(Collectors.joining());
        return whitespaces + str;
    }
}

package nextstep.ladder2;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import nextstep.ladder2.domain.NxLine;

public class Controller {

    public List<String> convertToLadderViewDto(List<NxLine> lines) {
        return lines.stream()
                .map(NxLine::getBridgeValues)
                .map(this::convertToLineViewDto)
                .collect(Collectors.toList());
    }

    private String convertToLineViewDto(List<Boolean> line) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for(int i = 0; i < line.size(); i++) {
            convertToStringIfTrue(line.get(i), i, stringJoiner);
        }
        return stringJoiner.toString();
    }

    private void convertToStringIfTrue(boolean bool, int index, StringJoiner stringJoiner) {
        if (bool) {
            stringJoiner.add(String.valueOf(index));
        }
    }
}

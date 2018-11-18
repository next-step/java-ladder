package domain.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LineCreation{

    public List<Lines> getLines(List<Line> line) {
        List<Lines> lines = new ArrayList<>();
        for(int i = 0; i < line.size(); i++){
            lines.add(new Lines(line));
        }
        return lines;
    }

}

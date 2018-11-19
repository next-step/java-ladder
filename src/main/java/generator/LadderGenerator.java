package generator;

import model.Line;
import model.Participant;

import java.util.ArrayList;
import java.util.List;

public interface LadderGenerator {
    public List<Line> getLines(String height, int countOfPerson);
}

package generator;

import model.Line;
import model.Participant;

import java.util.ArrayList;
import java.util.List;

public interface LadderGenerator {
    public List<Participant> getParticipants(String names);

    public List<Line> getLines(String height, int countOfPerson);

    public String[] split(String participants);
}

package view;

import java.util.List;

public interface Input {
    List<String> readPlayerNames();
    List<String> readResults();
    int readLadderHeight();
    String askPlayer();
}
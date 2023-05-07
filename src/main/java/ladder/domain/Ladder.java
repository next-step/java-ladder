package ladder.domain;

import ladder.control.Preferences;

public class Ladder {
    Lines lines;
    Pillars pillars;

    public Ladder(int height, int width) {
        pillars = new Pillars(height,width);
        lines = new Lines(height,width,Preferences.lineCount(width));
    }
}

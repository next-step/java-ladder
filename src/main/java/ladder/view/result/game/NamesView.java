package ladder.view.result.game;

import ladder.model.participant.Names;

public class NamesView implements FormattableView {
    private final Names names;

    public NamesView(Names names) {
        this.names = names;
    }

    @Override
    public void render(int formatWidth) {
        names.forEach((name) -> {
            System.out.printf("%" + formatWidth + "s", name);
        });
        System.out.println();
    }
}

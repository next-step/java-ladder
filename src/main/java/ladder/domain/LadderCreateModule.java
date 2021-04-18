package ladder.domain;

public final class LadderCreateModule {

    private static final class LadderCreateModuleHolder {
        private static final LadderCreateModule ladderCreateModule = new LadderCreateModule();
    }

    public LadderCreateModule() {
    }

    public static final LadderCreateModule getInstance() {
        return LadderCreateModuleHolder.ladderCreateModule;
    }
}

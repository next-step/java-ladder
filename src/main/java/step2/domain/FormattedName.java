package step2.domain;

class FormattedName extends Name {
    private final PositiveNumber width;

    FormattedName(final String name, final int width) {
        super(name);
        this.width = PositiveNumber.of(width);
    }

    @Override
    public String print() {
        final String origin = super.print();
        final int index = Math.min(origin.length(), width.getNumber());

        return String.format("%" + width.getNumber() + "s",
                             origin.substring(0, index));
    }
}

package icu.sunway.naraka.Entity.Action;

public abstract class AbstractAction {
    protected int value;

    public AbstractAction(int value) {
        this.value = value;
    }

    public abstract void execute();

    public abstract String getName();
}

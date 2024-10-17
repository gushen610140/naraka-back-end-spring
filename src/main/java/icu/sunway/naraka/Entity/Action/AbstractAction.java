package icu.sunway.naraka.Entity.Action;

import icu.sunway.naraka.Entity.Player.AbstractPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractAction {
    protected int value;
    protected String intro;
    protected String displayName;

    public abstract void execute(AbstractPlayer playerMe, AbstractPlayer playerOppo);
}

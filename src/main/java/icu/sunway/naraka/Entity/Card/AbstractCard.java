package icu.sunway.naraka.Entity.Card;

import icu.sunway.naraka.Entity.Player.AbstractPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractCard {
    protected int rageConsumption;
    protected String intro;
    protected String displayName;

    public abstract void execute(AbstractPlayer playerMe, AbstractPlayer playerOppo);
}

package icu.sunway.naraka.Entity.Player.PlayerImpl;

import icu.sunway.naraka.Entity.Player.AbstractPlayer;

public class PlayerWarrior extends AbstractPlayer {
    private static final int maxHealth = 3000;
    private static final String nickName = "Warrior";

    public PlayerWarrior() {
        super(maxHealth, nickName);
    }
}

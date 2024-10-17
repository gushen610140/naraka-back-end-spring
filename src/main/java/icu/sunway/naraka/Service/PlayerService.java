package icu.sunway.naraka.Service;

import icu.sunway.naraka.Entity.Action.AbstractAction;
import icu.sunway.naraka.Entity.Player.AbstractPlayer;
import icu.sunway.naraka.Entity.Player.PlayerImpl.PlayerWarrior;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final RedisTemplate<String, Object> redisTemplate;

    public PlayerService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void updatePlayerAction(String playerId, AbstractAction action) throws Exception {
        AbstractPlayer abstractPlayer = (AbstractPlayer) redisTemplate.opsForValue().get(playerId);
        if (abstractPlayer == null) {
            throw new Exception("abstractPlayer is null");
        }
        abstractPlayer.setAction(action);
        redisTemplate.opsForValue().set(playerId, abstractPlayer);
    }

    public void createPlayer(String nickName) {
        AbstractPlayer player = new PlayerWarrior();
        player.initPlayer(nickName);
        redisTemplate.opsForValue().set(player.getId(), player);
    }

    public AbstractPlayer getPlayer(String playerId) {
        return (AbstractPlayer) redisTemplate.opsForValue().get(playerId);
    }
}

package icu.sunway.naraka.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import icu.sunway.naraka.Entity.Action.AbstractAction;
import icu.sunway.naraka.Entity.Player.AbstractPlayer;
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
}

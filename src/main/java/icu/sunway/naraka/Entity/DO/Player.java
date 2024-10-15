package icu.sunway.naraka.Entity.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("players")
public class Player {
    String id;
    int health_max;
    int health_cur;
    String nickname;
    String status;
    int rage;
}
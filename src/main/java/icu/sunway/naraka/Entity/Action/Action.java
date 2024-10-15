package icu.sunway.naraka.Entity.Action;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("actions")
public class Action {
    private AbstractAction name;
    private int value;
    private String intro;
    private String cn_name;
}
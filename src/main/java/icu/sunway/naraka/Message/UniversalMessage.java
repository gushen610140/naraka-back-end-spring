package icu.sunway.naraka.Message;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
public class UniversalMessage {
    private Locale locale;
    @Getter
    private static final UniversalMessage instance = new UniversalMessage(Locale.ZH_CN);

    public String success() {
        Map<Locale, String> map = new HashMap<>() {{
           put(Locale.ZH_CN, "服务器响应成功，操作已完成");
           put(Locale.EN_US, "Server respond successfully, complete operation");
        }};

        return map.get(locale);
    }

    public String fail() {
        Map<Locale, String> map = new HashMap<>() {{
            put(Locale.ZH_CN, "服务器响应失败，请重新尝试");
            put(Locale.EN_US, "Server respond fail, please retry");
        }};

        return map.get(locale);
    }

    UniversalMessage(Locale locale) {
        this.locale = locale;
    }
}

package bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static final Map<String, String> DATA_CACHE = new HashMap<>();

    static {
        DATA_CACHE.put("10001", "XY");
        DATA_CACHE.put("10002", "八杯水");
        DATA_CACHE.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return DATA_CACHE.get(uId);
    }

}

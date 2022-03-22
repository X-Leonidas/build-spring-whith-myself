package bean;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;
@Log4j2
public class UserDao {

    private static final Map<String, String> DATA_CACHE = new HashMap<>();



    public void initDataMethod(){
        log.info("执行：init-method");
        DATA_CACHE.put("10001", "XXXXYYYYY");
        DATA_CACHE.put("10002", "八杯水");
        DATA_CACHE.put("10003", "阿毛");
    }

    public void destroyDataMethod(){
        log.info("执行：destroy-method");
        DATA_CACHE.clear();
    }

    public String queryUserName(String uId) {
        return DATA_CACHE.get(uId);
    }

}

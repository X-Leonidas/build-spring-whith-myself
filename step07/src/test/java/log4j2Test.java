import lombok.extern.log4j.Log4j2;

@Log4j2
public class log4j2Test {

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            // 记录trace级别的信息
            log.trace("log4j2日志输出：This is trace message.");
            // 记录debug级别的信息
            log.debug("log4j2日志输出：This is debug message.");
            // 记录info级别的信息
            log.info("log4j2日志输出：This is info message.");
            // 记录error级别的信息
            log.error("log4j2日志输出：This is error message.");
        }
    }
}
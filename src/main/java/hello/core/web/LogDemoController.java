package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor        // 생성자 자동 생성, Autowired
public class LogDemoController {
    private final LogDemoService logDemoService;
    // request 스코프는 요청이 들어오고 나갈때만 살아있는데, 요청이 없는데 바로 주입받으려해서
    // 에러가 발생한다.
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    // HttpServletRequest request : 클라이언트 요청 정보를 얻을 수 있다.
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);
        System.out.println("myLogger = " + myLogger.getClass());

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}

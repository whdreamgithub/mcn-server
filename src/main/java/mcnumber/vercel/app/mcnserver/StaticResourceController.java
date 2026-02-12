package mcnumber.vercel.app.mcnserver;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author: Felix
 * @create: 2026/2/12
 * @Description:
 */
@Controller
public class StaticResourceController {

    // 拦截所有jsp文件的POST请求
    @RequestMapping(value = "/ajax/*.jsp", method = RequestMethod.POST)
    public void serveJsp1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getRequestURI();

        // 从classpath读取静态文件
        Resource resource = new ClassPathResource("static" + path);

        if (resource.exists()) {
            response.setContentType("text/html;charset=UTF-8");
            Files.copy(resource.getFile().toPath(), response.getOutputStream());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }




}
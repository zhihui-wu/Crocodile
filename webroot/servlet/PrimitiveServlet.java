import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description: TODO
 * @Author: 吴智慧
 * @Date: 2019/11/8 09:01
 */
public class PrimitiveServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
        PrintWriter out = servletResponse.getWriter();
        out.println("Hello, Roses are red!");
        out.println("Violets are blue!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}

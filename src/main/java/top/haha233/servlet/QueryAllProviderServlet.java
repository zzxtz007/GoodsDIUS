package top.haha233.servlet;

import com.google.gson.Gson;
import top.haha233.service.impl.ProviderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ice_Dog
 */
@WebServlet(name = "QueryAllProviderServlet", urlPatterns = {"/QueryAllProviderServlet", "/api/provider/query"})
public class QueryAllProviderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		Gson g= new Gson();
		response.getWriter().print(g.toJson(new ProviderServiceImpl().query()));
	}
}

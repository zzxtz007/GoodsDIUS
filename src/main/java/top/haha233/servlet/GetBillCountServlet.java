package top.haha233.servlet;

import com.google.gson.Gson;
import top.haha233.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ice_Dog
 */
@WebServlet(name = "GetBillCountServlet", urlPatterns = {"/GetBillCountServlet","/api/bill/count"})
public class GetBillCountServlet extends HttpServlet {
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
		Gson g = new Gson();
		String billCode = request.getParameter("billCode");
		String productName = request.getParameter("productName");
		String productDesc = request.getParameter("productDesc");
		String productUnit = request.getParameter("productUnit");
		String productCount = request.getParameter("productCount");
		String totalPrice = request.getParameter("totalPrice");
		String isPayment = request.getParameter("isPayment");
		String providerId = request.getParameter("providerId");
		response.getWriter().print(g.toJson(new BillServiceImpl()
				.count(billCode, productName, productDesc, productUnit, productCount, totalPrice,
						isPayment, providerId)));
	}
}

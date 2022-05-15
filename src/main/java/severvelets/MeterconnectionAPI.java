package severvelets;

import jakarta.servlet.http.HttpServlet;
import com.electricgrid.meterconnection.Meterconnection;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MeterconnectionAPI
 */
public class MeterconnectionAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	Meterconnection meterc = new Meterconnection();
    public MeterconnectionAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String result = meterc.insertmeterconnection(request.getParameter("mc_type"),
			     request.getParameter("mc_phase_type"),
				request.getParameter("mc_capacity"),
				request.getParameter("mc_monthly_unit_usage"),request.getParameter("mc_validity_status"),
				request.getParameter("mc_power_distribution_status"),request.getParameter("user_acc_id"),
				request.getParameter("billing_id"));

		response.getWriter().write(result);
		
	}
	
	private Map<String, String> getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();

			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> param = getParasMap(request);

		String result = meterc.updatePayment(param.get("hidmc_idSave").toString(),
				param.get("mc_type").toString().toString().replace("+", " "),
				param.get("mc_phase_type").toString().toString().replace("+", " "),
				param.get("mc_capacity").toString().toString().replace("+", " "),
				param.get("mc_monthly_unit_usage").toString().toString().replace("+", " "), 
				param.get("mc_validity_status").toString().toString().replace("+", " "), 
				param.get("mc_power_distribution_status").toString().toString().replace("+", " "), 
				param.get("user_acc_id	").toString().toString().replace("+", " "), 
			    param.get("billing_id").toString());

		response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> param = getParasMap(request);

		String result = meterC.deleteMeterconnection(param.get("mc_id").toString());

		response.getWriter().write(result);
	}

}

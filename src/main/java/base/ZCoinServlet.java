package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class ZCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("page");
		
		
		if (query.equalsIgnoreCase("user-signup")) {
			String name = request.getParameter("name");
			String emailId = request.getParameter("email");
			long mobileNumber = Long.parseLong(request.getParameter("mobile"));
			int hId = Integer.parseInt(request.getParameter("hid"));
			String password = request.getParameter("password");
			long initialDeposit = Long.parseLong(request.getParameter("deposit"));
			
			Customer customer = ObjectCreator.createCustomer(name, emailId, mobileNumber, hId, password, initialDeposit);
			Record.INSTANCE.addToCustomers(customer);
			
			PrintWriter pw = response.getWriter();
			pw.print("User added. Waiting for approval");
		}
		
		else if (query.equalsIgnoreCase("user-login")) {
			int hid = Integer.parseInt(request.getParameter("hid"));
			String password = request.getParameter("password");
			if(Record.INSTANCE.getCustomers().containsKey(hid)) {
				if (Record.INSTANCE.getCustomers().get(hid).getPassword().equals(password)) {
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
				}
			}
			
		}
		
		else if (query.equalsIgnoreCase("agent-login")) {
			if(request.getParameter("name").equals("admin") && request.getParameter("password").equals("admin")) {
				request.setAttribute("data", Record.INSTANCE.getCustomers().values());
				RequestDispatcher rd = request.getRequestDispatcher("approve-users.jsp");
				rd.forward(request, response); 
			}
			else {
				PrintWriter pw = response.getWriter();
				pw.print("Access denied");
			}
			
		}
		
		else if (query.equalsIgnoreCase("approve-user")) {
			
			int key = Integer.parseInt(request.getParameter("hid"));
			
			Customer customer = Record.INSTANCE.getCustomers().get(key);
			try {
				DBConnector.addUser(customer);
			} catch (CustomException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		else if (query.equalsIgnoreCase("change-password")) {
			
			int hid = Integer.parseInt(request.getParameter("hid"));
			String oldPassword = request.getParameter("old-password");
			String newPassword = request.getParameter("new-password");
			
			if(Record.INSTANCE.getCustomers().containsKey(hid)) {
				if (Record.INSTANCE.getCustomers().get(hid).getPassword().equals(oldPassword)) {
					try {
						DBConnector.updatePassword(hid, newPassword);
					} catch (CustomException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
				}
			}
		}
		
	}

}

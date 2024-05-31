package employee;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EmployeeController", value = "/employee")
public class EmployeeController extends HttpServlet {

    EmployeeDao empdao;

    public EmployeeController() {
        empdao = new EmployeeDao();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Get request received");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstNameUi = request.getParameter("firstname_ui");
        String lastNameUi = request.getParameter("lastname_ui");
        String emailUi = request.getParameter("email_ui");
        String userNameUi = request.getParameter("username_ui");
        String passwordUi = request.getParameter("password_ui");

        String accountStatus = "Deactivated";

        //Make employee object

        Employee employee = new Employee(firstNameUi, lastNameUi, emailUi, userNameUi, passwordUi, accountStatus);

        boolean boolReturn = empdao.insertEmployee(employee);

        PrintWriter pw = response.getWriter();
        if (boolReturn) {
            pw.println("<script>"
                    + "alert('Successfully registered!!');"
                    + "window.location.href = 'index.html';"
                    + "</script>");

        } else {
            pw.println("<script>"
                    + "alert('Failed!!');"
                    + "window.location.href = 'index.html';"
                    + "</script>");
        }

    }
}
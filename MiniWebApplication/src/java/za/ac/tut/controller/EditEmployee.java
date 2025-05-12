
package za.ac.tut.controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.EmployeeFacadeLocal;
import za.ac.tut.entities.Employee;

public class EditEmployee extends HttpServlet {

    @EJB
    EmployeeFacadeLocal efl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");

        Employee emp = efl.find(id);
        emp.setName(name);
        efl.edit(emp);
        request.setAttribute("emp", emp);

        RequestDispatcher disp = request.getRequestDispatcher("editEmployee_outcome.jsp");
        disp.forward(request, response);
    }
}

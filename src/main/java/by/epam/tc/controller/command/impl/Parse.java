package by.epam.tc.controller.command.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.tc.controller.command.Command;
import by.epam.tc.entity.Application;
import by.epam.tc.service.ApplicationServiceImp;
import by.epam.tc.service.ServiceException;

public class Parse implements Command {

	private static final String PATH = "C:\\Users\\nekoma\\eclipse-workspace\\xml_parser\\src\\main\\resources\\applications.xml";
	private static final String RESULT_PAGE = "WEB-INF/jsp/resultPage.jsp";
	private static final String ERROR_PAGE = "error.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Application> app = new ArrayList<Application>();
		String typeParser = request.getParameter("type_parse");
		
		ApplicationServiceImp service = new ApplicationServiceImp();
		
		File file = new File(PATH);
		
		try {
			app = service.getApplications(typeParser, file);
			request.setAttribute("application", app);
		} catch (ServiceException e) {
			response.sendRedirect(ERROR_PAGE);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(RESULT_PAGE);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(ERROR_PAGE);
		}
		
	}

}

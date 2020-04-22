package by.epam.tc.service;

import java.io.File;
import java.util.List;

import by.epam.tc.dao.DAOException;
import by.epam.tc.dao.DAOParser;
import by.epam.tc.dao.DAOParserFactory;
import by.epam.tc.entity.Application;

public class ApplicationServiceImp {
	
	public List<Application> getApplications(String typeParser, File inputXml) throws ServiceException {
		DAOParser parser = DAOParserFactory.getInstance().getParser(typeParser);
		try {
			return parser.getApplications(inputXml);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}

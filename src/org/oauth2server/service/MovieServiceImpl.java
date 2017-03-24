package org.oauth2server.service;

import java.util.List;

import org.oauth2server.AppException;
import org.oauth2server.dao.MovieDao;
import org.oauth2server.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of movie service.
 * 
 * @author psajja
 *
 */
public class MovieServiceImpl implements MovieService {

	 @Autowired  
	 MovieDao movieDao;  
	 
	@Override
	public Movie getMovieById(String id) throws AppException {
		return movieDao.getMovieById(id);
	}

	@Override
	public List<Movie> list() throws AppException {
		return movieDao.list();
	}
}

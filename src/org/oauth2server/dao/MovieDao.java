package org.oauth2server.dao;

import java.util.List;

import org.oauth2server.AppException;
import org.oauth2server.model.Movie;

/**
 * DAO object accessing movie database.
 * 
 * @author psajja
 *
 */
public interface MovieDao {

	/**
	 * Get the movie details given the movie id.
	 * 
	 * @param id
	 * 		movie id
	 * 
	 * @return
	 * 		movie object
	 * 
	 * @throws AppException
	 * 		if there is some problem in retrieving movie
	 */
	public Movie getMovieById(String id) throws AppException;  
	
	/**
	 * Get the list of movies currently available.
	 * 
	 * @return
	 * 		list of movies
	 * 
	 * @throws AppException
	 * 		if there is some problem in retrieving movies
	 */
	public List<Movie> list() throws AppException;  
}

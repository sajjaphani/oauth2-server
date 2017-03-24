package org.oauth2server.service;

import java.util.List;

import org.oauth2server.AppException;
import org.oauth2server.model.Movie;

/**
 * Movie service.
 * 
 * @author psajja
 *
 */
public interface MovieService {

	/**
	 * Get the movie object given a unique movie id.
	 * 
	 * @param id
	 * 		the movie id
	 * @return
	 * 		the movie object
	 * 
	 * @throws AppException
	 * 		if there is any problem in retrieving the movie
	 */
	public Movie getMovieById(String id) throws AppException;  
	
	/**
	 * Get the movie list.
	 * 
	 * @return
	 * 		list of movies currently available.
	 * 
	 * @throws AppException
	 * 		if there is any problem in retrieving the movies
	 */
	public List<Movie> list() throws AppException;  
}

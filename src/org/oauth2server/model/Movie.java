package org.oauth2server.model;

/**
 * Movie model object
 * 
 * @author psajja
 *
 */
public class Movie {

	private String id;
	private String name;
	private int year;
	private String [] stars;
	
	/**
	 * Default constructor.
	 */
	public Movie() {
	}
	
	/**
	 * Get the movie id.
	 * 
	 * @return
	 * 		the movie id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Set the movie id.
	 * 
	 * @param id
	 * 		the movie id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Get the name of the movie.
	 * 
	 * @return
	 * 		the movie name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the movie name.
	 * 
	 * @param name
	 * 		name of the movie
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the year of release.
	 * 
	 * @return
	 * 		release year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Set the year of release.
	 * 
	 * @param year
	 * 		the release year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Get the lead stars of the movie.
	 * 
	 * @return
	 * 		the leas stars
	 */
	public String [] getStars() {
		return stars;
	}
	
	/**
	 * Set the lead stars of the movie.
	 * 
	 * @param stars
	 * 		the lead start
	 */
	public void setStars(String [] stars) {
		this.stars = stars;
	}
}

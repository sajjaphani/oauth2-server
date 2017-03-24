package org.oauth2server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.oauth2server.AppException;
import org.oauth2server.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of movie DAO, based on <code>JdbcTemplate</code>.
 * 
 * @author psajja
 *
 */
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	private static final String QUERY_MOVIES = "SELECT * FROM movies";
	private static final String QUERY_MOVIE_BY_ID = "SELECT * FROM movies WHERE movie_id = ?";
	
	/**
	 * Get the JdbcTemplate.
	 * 
	 * @return
	 * 		the jdbc template
	 */
	private JdbcTemplate getJdBcTemplate() {
		if(jdbcTemplate == null)
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		return jdbcTemplate;
	}
	
	@Override
	public Movie getMovieById(String id) throws AppException {
		return getJdBcTemplate().queryForObject(QUERY_MOVIE_BY_ID, 
                new Object[]{id}, new MovieMapper());
	}

	@Override
	public List<Movie> list() throws AppException {
		return getJdBcTemplate().query(QUERY_MOVIES, 
                new MovieMapper());
	}

	/**
	 * Mapper to map each of the movie row.
	 * 
	 * @author psajja
	 *
	 */
	private class MovieMapper implements RowMapper<Movie> {

		@Override
		public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
			Movie movie = new Movie();
			movie.setId(rs.getString("movie_id"));
			movie.setName(rs.getString("name"));
			movie.setYear(rs.getInt("year"));
			movie.setStars(rs.getString("stars").split(","));
		
			return movie;
		}
	}
}
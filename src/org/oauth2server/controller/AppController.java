package org.oauth2server.controller;

import java.util.List;

import org.oauth2server.AppException;
import org.oauth2server.model.Movie;
import org.oauth2server.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller class to handle different requests.
 * 
 * @author psajja
 *
 */
@Controller
public class AppController {

	@Autowired
	private MovieService movieService;

	@RequestMapping("/")
	public ModelAndView helloWorld() {

		String message = "Welcome Boss!";
		return new ModelAndView("index", "message", message);
	}

	@RequestMapping(value = "/sayhello/{name}", method = RequestMethod.GET)
	public String getRequest(@PathVariable String name, ModelMap model) {
		model.addAttribute("name", name);
		return "sayback";
	}

	@RequestMapping(value = "/rest/api/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String saybackGet(@PathVariable String name) {
		return "Hello Boss: " + name;
	}

	@RequestMapping(value = "/rest/api", method = RequestMethod.POST)
	@ResponseBody
	public String saybackPost(@RequestParam(value="userName", required=false) String userName) {
		return "Hello Boss: " + userName;
	}
	
	@RequestMapping(value = "/rest/api/list-movies", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Movie> listMoviesGet() {
		try {
			return movieService.list();
		} catch (AppException e) {
			// TODO - do useful/log it
			return null;
		}
	}

	@RequestMapping(value = "/rest/api/list-movies", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<Movie> listMoviesPost() {
		try {
			return movieService.list();
		} catch (AppException e) {
			// TODO - do useful/log it
			return null;
		}
	}
	
	@RequestMapping(value = "/rest/api/get-movie/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Movie listMoviesByIdGet(@PathVariable String id) {
		try {
			return movieService.getMovieById(id);
		} catch (AppException e) {
			// TODO - do useful/log it
			return null;
		}
	}
	
	@RequestMapping(value = "/rest/api/get-movie", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Movie listMoviesByIdPost(@ModelAttribute("movieId") String id) {
		try {
			return movieService.getMovieById(id);
		} catch (AppException e) {
			// TODO - do useful/log it
			return null;
		}
	}
}
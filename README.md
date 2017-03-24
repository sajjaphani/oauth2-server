# OAuth 2 Server

This repository contains a sample Web application that enable clients to access the REST APIs through OAuth 2 authentication.

This application is a Maven project and used Eclipse as a development IDE and below are the details of the environment.

  - JDK 1.8
  - Apache Tomcat (8.0.21)
  - Spring Framework (4.1.7)
  - Spring Security (4.0.2)
  - MySQL Community Server (5.6.26)
  - others (see pom.xml)

Below are the contents of this repository.

  - .settings - Eclipse stuff
  - WebContent - Contains Web application stuff including configuration files of Web App and Spring Security etc.
  - data - Contains sample MySQL commands and database dump
  - src - Contains the source code
  - .classpath - Eclipse stuff
  - .gitignore - Ignore configuration for GIT
  - .project - Eclipse stuff
  - README.md - This file
  - pom.xml - Project and configuration information for the Maven

# Setting Up the Server

Follow below steps and make sure your App is running on server

  - Start MySQL Server Daemon - data directory contains sample commands and also a dump file of the database used for this App
  - Import the App in Eclipse IDE for Java EE Developers and run the application using Run As -> Run on Server option from the project context menu.

You can also:
  - Bundle the App into a War file and deploy on to the Tomcat Server.

# Accessing the API

This section provides details of how to obtain token and further access the APIs with the access token. This section assumes that the server is running at URL http://localhost:8080/oauth2-server. Use any of the REST client for accessing the URLs described in this section.

### Accessing the Token

Do a POST request at http://localhost:8080/oauth2-server/oauth/token?username=api-user&password=api-pass&grant_type=password&client_id=restapi-client-id&client_secret=restapi-client-password&scope=read,trust,write

The server response will look like the below one.

  ```json
{
	"value": "6d210bd8-6bc4-4b18-9efb-851000626e46",
	"expiration": "Mar 24, 2017 4:07:31 PM",
	"tokenType": "bearer",
	"refreshToken": {
		"expiration": "Apr 23, 2017 3:57:31 PM",
		"value": "4323a5c1-5d9e-4560-bbdf-838bbbdb8ade"
	},
	"scope": [
		"read,trust,write"
	],
	"additionalInformation": {}
}
  ```

### Accessing the API

Use the obtained token '6d210bd8-6bc4-4b18-9efb-851000626e46' to access the APIs shown below.

Below REST call (GET or POST) will obtain the list of movies in the database.
http://localhost:8080/oauth2-server/rest/api/list-movies?access_token=6d210bd8-6bc4-4b18-9efb-851000626e46

```json
[
    {
        "id": "tt0060196",
        "name": "The Good, the Bad and the Ugly",
        "year": 1966,
        "stars": [
            "Clint Eastwood",
            "Eli Wallach"
        ]
    },
    {
        "id": "tt0073486",
        "name": "One Flew Over the Cuckoo's Nest",
        "year": 1975,
        "stars": [
            "Jack Nicholson",
            "Louise Fletcher"
        ]
    },
    {
        "id": "tt0068646",
        "name": "The Godfather",
        "year": 1972,
        "stars": [
            "Marlon Brando",
            " Al Pacino",
            " James Caan"
        ]
    },
    {
        "id": "tt0110912",
        "name": "Pulp Fiction",
        "year": 1994,
        "stars": [
            " John Travolta",
            " Uma Thurman",
            " Samuel L. Jackson"
        ]
    },
    {
        "id": "tt0110413",
        "name": "Léon: The Professional",
        "year": 1994,
        "stars": [
            " Jean Reno",
            " Gary Oldman",
            " Natalie Portman"
        ]
    }
]
```

Below REST call (GET or POST) will obtain a movie details given the id of the movie.
http://localhost:8080/oauth2-server/rest/api/get-movie/tt0110413?access_token=6d210bd8-6bc4-4b18-9efb-851000626e46

```json
{
	"id": "tt0110413",
	"name": "Léon: The Professional",
	"year": 1994,
	"stars": [
		" Jean Reno",
		" Gary Oldman",
		" Natalie Portman"
	]
}
```

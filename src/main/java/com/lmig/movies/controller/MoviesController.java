/*
 * Copyright (C) 2018, Liberty Mutual Group
 *
 * Created on Apr 9, 2018
 */

package com.lmig.movies.controller;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.web.bind.annotation.RestController; 

@RestController
public class MoviesController {

    @Autowired  
    JdbcTemplate jdbc; 
    
    @RequestMapping("/insert-movie")  
    public String insertMovie(){  
        jdbc.execute("insert into movies(title,year,image_url,certificate,runtime,imdb_rating,description,metascore,votes,gross)values('Tomb Raider',2018,'https://ia.media-imdb.com/images/M/MV5BOTY4NDcyZGQtYmVlNy00ODgwLTljYTMtYzQ2OTE3NDhjODMwXkEyXkFqcGdeQXVyNzYzODM3Mzg@._V1_UX67_CR0,0,67,98_AL_.jpg','PG-13',118,6.8,'Lara Croft, the fiercely independent daughter of a missing adventurer, must push herself beyond her limits when she finds herself on the island where her father disappeared.',48,42587,52150000)");  
      //jdbc.query(psc, rse)execute("insert into user(name,email)values('denise','denise@gmail.com')");  
        //jdbc.execute("insert into movies(title,year)values('Ready Player One',2018)");  
        return "data inserted Successfully";  
    }
    
    @RequestMapping("/update-movie")  
    public String updateMovie(){  
        //jdbc.execute("update movies set image_url = 'https://ia.media-imdb.com/images/M/MV5BY2JiYTNmZTctYTQ1OC00YjU4LWEwMjYtZjkwY2Y5MDI0OTU3XkEyXkFqcGdeQXVyNTI4MzE4MDU@._V1_UX67_CR0,0,67,98_AL_.jpg' where id = 4");  
        //jdbc.execute("update movies set votes = 55723 where id = 4");
        jdbc.execute("update movies set runtime = 140 where id = 4");
        jdbc.execute("update movies set imdb_rating = 8.0 where id = 4");
        jdbc.execute("update movies set description = 'When the creator of a virtual reality world called the OASIS dies, he releases a video in which he challenges all OASIS users to find his Easter Egg, which will give the finder his fortune.' where id = 4");
        jdbc.execute("update movies set metascore = 64 where id = 4");
        return "data updated Successfully";  
    }
    
    @RequestMapping("/insert-directors")  
    public String insertDir(){  
        jdbc.execute("insert into directors(name,about)values('Roar Uthaug ','Roar')");  
        return "data inserted Successfully";  
    }
    
    @RequestMapping("/insert-stars")  
    public String insertStar(){  
        jdbc.execute("insert into stars(name,about)values('Dominic West','Actor')");  
        return "data inserted Successfully";  
    }
    
    @RequestMapping("/insert-movie-director")  
    public String insertMovieDir(){  
        jdbc.execute("insert into movies_directors(movies_id,directors_id)values(5,7)");  
        return "data inserted Successfully";  
    }
    
    @RequestMapping("/insert-movie-stars")  
    public String insertMovieStar(){  
        jdbc.execute("insert into movies_stars(movies_id,stars_id)values(5,16)");  
        return "data inserted Successfully";  
    }
    
    @RequestMapping("/insert-movie-genres")  
    public String insertMovieGenre(){  
        jdbc.execute("insert into movies_genres(movies_id,genres_id)values(5,2)");  
        return "data inserted Successfully";  
    }
    
    @RequestMapping("/select-all-movies")  
    public String selectAllMovies(){ 
        jdbc.execute("select * from movies"); 
        return "data retrieved Successfully";  
    }
    
    @RequestMapping("/select-movie-byId")   
    public String selectMovieById(){ 
        jdbc.execute("select * from movies where id = 4"); 
        return "data retrieved Successfully";  
    }
    
    @RequestMapping("/select-genres-by-movie")
    public String selectGenresByMovie(){ 
        jdbc.execute("select name from genres as a join movies_genres as b on b.genres_id = a.id join movies as c on c.id = b.movies_id where c.title in('Gladiator')"); 
        return "data retrieved Successfully";  
    }

    @RequestMapping("/select-stars-by-movie")
    public String selectStarsByMovie(){ 
        jdbc.execute("select name from stars as a join movies_stars as b on b.stars_id = a.id join movies as c on c.id = b.movies_id where c.title in('Gladiator')"); 
        return "data retrieved Successfully";  
    }
    
    @RequestMapping("/select-directors-by-movie")
    public String selectDirectorsByMovie(){ 
        jdbc.execute("select name from directors as a join movies_directors as b on b.directors_id = a.id join movies as c on c.id = b.movies_id where c.title in('Gladiator')"); 
        return "data retrieved Successfully";  
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import proyecto2.Pelicula;
import java.time.LocalDate;

public class Movies {
    public ArrayList<Pelicula> obtenerPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try {
            URL url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=05e231f450f8eb53ac911700a7ea6873");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonArray results = jsonObject.getAsJsonArray("results");

            for (int i = 0; i < results.size(); i++) {
                JsonObject movie = results.get(i).getAsJsonObject();
                String title = movie.get("title").getAsString();
                String originalTitle = movie.get("original_title").getAsString();
                String overview = movie.get("overview").getAsString();
                String posterPath = movie.get("poster_path").getAsString();
                String release_date = movie.get("release_date").getAsString();
    
                LocalDate releaseDate = LocalDate.parse(release_date);
                Pelicula peli = new Pelicula(title, originalTitle, overview, posterPath, releaseDate);
                peliculas.add(peli);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peliculas;
    }
}

  


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Proyecto2 extends JFrame {

    ArrayList<Pelicula> peliculas = new ArrayList<>();

    public Proyecto2() {
        setTitle("Movies from TMDb");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<ImageIcon> movieListModel = new DefaultListModel<>();
        JList<ImageIcon> movieList = new JList<>(movieListModel);
        JScrollPane scrollPane = new JScrollPane(movieList);
        add(scrollPane);

        try {
            URL url = new URL("https://api.themoviedb.org/3/movie/popular?language=en-US&page=1&api_key=404afbb2bf7ad6cfb120c64e8016dccf");
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
                String posterPath = movie.get("poster_path").getAsString();

                // Load image from URL
                ImageIcon imageIcon = new ImageIcon(new URL("https://image.tmdb.org/t/p/w500" + posterPath));

                // Create Pelicula objects if needed
                Pelicula peli = new Pelicula(title, title, " ", posterPath);
                peliculas.add(peli);

                // Add image to the list model
                movieListModel.addElement(imageIcon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Proyecto2 frame = new Proyecto2();
            frame.setVisible(true);
        });
    }
}
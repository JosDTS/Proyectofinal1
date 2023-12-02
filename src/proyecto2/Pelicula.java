/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import com.google.gson.JsonElement;
import java.time.LocalDate;
import java.util.List;
import javax.swing.ImageIcon;

public class Pelicula {
    private String titulo;
    private String originalTitle;
    private String overview;
    private String posterPath;
    private LocalDate releaseDate;

    public Pelicula(String titulo, String originalTitle, String overview, String posterPath, LocalDate releaseDate) {
        this.titulo = titulo;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
     
    }
 
   
    

    public Pelicula() {
    }

   

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }


    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", originalTitle=" + originalTitle + ", overview=" + overview + ", posterPath=" + posterPath + ", releaseDate=" + releaseDate + '}';
    }

   
     
}

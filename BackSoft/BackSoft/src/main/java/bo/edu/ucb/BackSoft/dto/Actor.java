package bo.edu.ucb.BackSoft.dto;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Actor {
     Integer filmId;
    private String title;
    private String description;
    private Integer length;
    private String lengthLabel;
    private String language;
    private String originalLanguage;
     Integer actorId;
    private String name;
    private String last;
 

    public Actor() {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        
        return actorId.equals(actor.actorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId);
    }

    @Override
    public String toString() {
        return 
                "title='" + title + '\n' +
                "description='" + description + '\n' +
                "lengthLabel='" + lengthLabel + '\n' +
                " actor='" + name+" "+last + '\n' 
                ;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }


    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }


    public String getLanguage() {
        return language;
    }


    public void setLanguage(String language) {
        this.language = language;
    }


   
    
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getLengthLabel() {
        return lengthLabel;
    }

    public void setLengthLabel(String lengthLabel) {
        this.lengthLabel = lengthLabel;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        if (length != null) { // Algoritmo para convertir a horas minutos
            int hours = length / 60;
            int minutes = length % 60;
            if (hours > 0) {
                lengthLabel = hours + "h " + minutes + "m";
            } else {
                lengthLabel = minutes + "m";
            }

        }
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }  
}

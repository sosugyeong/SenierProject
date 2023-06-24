package com.rec.movie;

public class MovieDto {
    private String movieSeq;
    private String title;
    private String directorNm;
    private String actorNm;
    private String nation;
    private String runtime;
    private String genre;
    private String type;
    private String rating;
    private String releaseDate;
    private String posterUrl;
    private String plot;

    public MovieDto(String movieSeq, String title, String directorNm, String actorNm, String nation, String runtime,
                    String genre, String type, String rating, String releaseDate, String posterUrl, String plot){

        this.movieSeq = movieSeq;
        this.title = title;
        this.directorNm = directorNm;
        this.actorNm = actorNm;
        this.nation = nation;
        this.runtime = runtime;
        this.genre = genre;
        this.type = type;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.posterUrl = posterUrl;
        this.plot = plot;
    }

    public String getMovieSeq() {
        return movieSeq;
    }

    public void setMovieSeq(String movieSeq) {
        this.movieSeq = movieSeq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectorNm() {
        return directorNm;
    }

    public void setDirectorNm(String directorNm) {
        this.directorNm = directorNm;
    }

    public String getActorNm() {
        return actorNm;
    }

    public void setActorNm(String actorNm) {
        this.actorNm = actorNm;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}

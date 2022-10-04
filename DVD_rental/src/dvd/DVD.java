package dvd;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DVD {
    private String title;
    private Genre genre;
    private Date releaseDate;
    private Double price;
    private boolean isAvailable;
    private String rentedBy;

    public DVD() {};

    public DVD(String title, Genre genre, Date releaseDate, Double price, boolean isAvailable) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public DVD(String title, Genre genre, Date releaseDate, Double price, boolean isAvailable, String rentedBy) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.price = price;
        this.isAvailable = isAvailable;
        this.rentedBy = rentedBy;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getRentedBy() {
        return rentedBy;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setRentedBy(String rentedBy) {
        this.rentedBy = rentedBy;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", genre=" + genre +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", rentedBy=" + rentedBy +
                '}';
    }
    public List<String> toStringList() {
        List<String> list = Arrays.asList(title, genre.toString(), releaseDate.toString(), price.toString(), String.valueOf(isAvailable), rentedBy);
        return list;
    }
}
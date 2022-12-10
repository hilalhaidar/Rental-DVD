public abstract class Dvd {
    public String title;
    public String genre;
    private int year;
    private int price_day;

    public Dvd(String title){
        this.title = title; 
    }

    public void display(){
        System.out.println("Genre "+this.title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setPriceDay(int price_day) {
        this.price_day = price_day;
    }

    public int getPriceDay() {
        return price_day;
    }
}
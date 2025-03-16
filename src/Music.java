public class Music {
    private String name;
    private String artist;
    private String number;
    private String url;

    public Music(String name, String artist, String number, String url) {
        this.name = name;
        this.artist = artist;
        this.number = number;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getNumber() {
        return number;
    }

    public String getUrl() {
        return this.url + getNumber() + ".mp4";
    }

}

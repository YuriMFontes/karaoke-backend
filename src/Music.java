public class Music {
    private String name;
    private String artist;
    private String number;
    private String pathFile;

    public Music(String name, String artist, String number, String pathFile) {
        this.number = number;
        this.name = name;
        this.artist = artist;
        this.pathFile = pathFile;
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

    public String getPathFile() {
        return pathFile;
    }

    public String takeURL(){
        return this.pathFile + getNumber() + ".mp4";
    };
}

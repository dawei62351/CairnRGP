public class World {
    private String gameName;
    private String publisher;


    World (String gN, String pub){
        this.gameName = gN;
        this.publisher = pub;
    }


    public String getGameName() {return gameName;}

    public void setGameName(String gameName) {this.gameName = gameName;}

    public String getPublisher() {return publisher;}

    public void setPublisher(String publisher) {this.publisher = publisher;}
}

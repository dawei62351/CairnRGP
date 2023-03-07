// Liza Kim
public class World {
    private String gameName;
    private String publisher;


    World (String gN, String pub){
        this.gameName = gN;
        this.publisher = pub;
    }
    World () {
        gameName = "The Greatest RPG of All Time";
        publisher = "CIS Duets";
    }


    public String getGameName() {return gameName;}

    public void setGameName(String gameName) {this.gameName = gameName;}

    public String getPublisher() {return publisher;}

    public void setPublisher(String publisher) {this.publisher = publisher;}
}

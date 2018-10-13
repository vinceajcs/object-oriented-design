package rssfeed;

public class SportClient implements Client {
    private String sport;
    private ScoreService service;

    public SportClient(String sport, ScoreService service) {
        this.sport = sport;
        this.service = service;
        service.addObserver(this);
    }
    public void newScore(String sport, String hometeam, String awayteam, String homescore, String awayscore) {
        if (sport.isEmpty() || hometeam.isEmpty() || awayteam.isEmpty() || homescore.isEmpty() || awayscore.isEmpty()) {
            System.out.println("Please fill in all the text fields!");
        } else if (this.sport.toLowerCase().equals(sport.toLowerCase())) {
            System.out.println("New " + sport.toLowerCase() + " score: "
                    + hometeam + " " + homescore + ", "
                    + awayteam + " " + awayscore);
        }
    }
}

package rssfeed;

public class TeamClient implements Client {
    private String team;
    private ScoreService service;

    public TeamClient(String team, ScoreService service) {
        this.team = team;
        this.service = service;
        service.addObserver(this);
    }

    public void newScore(String sport, String hometeam, String awayteam, String homescore, String awayscore) {
        if (sport.isEmpty() || hometeam.isEmpty() || awayteam.isEmpty() || homescore.isEmpty() || awayscore.isEmpty()) {
            System.out.println("Please fill in all the text fields!");
        } else if (team.toLowerCase().equals(hometeam.toLowerCase())) {
            System.out.println("New score in " + hometeam + " " + sport + ": " + hometeam + " " + homescore + ", "
                    + awayteam + " " + awayscore);
        } else if (team.toLowerCase().equals(awayteam.toLowerCase())) {
            System.out.println("New score in " + awayteam + " " + sport + ": " + hometeam + " " + homescore + ", "
                    + awayteam + " " + awayscore);
        }

    }
}

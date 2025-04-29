package tournament;
import Dictionary.*;
public interface MatchMapInterface<String,Match> extends DictionaryInterface<String,Match>
{
    
    int numberofMatches();
    //void printMatches();
    void addMatch(String match);
    // void removeMatch(String key);
    // Match getHighestGDMatch();
    // etc
    
}
class Match{
    // Match is an object not a method so we can store matches as objects in a Dictionary to store each match as an object
    String team1;
    int team1Goals;
    int team2Goals; 
    String team2;

    public Match(String team1, int team1Goals, int team2Goals, String team2)
    {
        this.team1 = team1;
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
        this.team2 = team2;
    }

    @Override
    public String toString()
    {
        return "Match{" + "team1=" + team1 + ", team1Goals=" + team1Goals  + ", team2=" + team2 + ", team2Goals=" + team2Goals+'}';
    }
    
}
 

package tournament;
import Dictionary.*; // local dictionary not java dictionary
public interface TournamentInterface<String,Team> extends DictionaryInterface<String, Team>
{
    
    

    // add team with no previous record
    void addTeam(String name);
    // add team with record or update 
    void addTeam(String name, Team team);
    // add played match
    void addMatch(String match);
    // total number of matches
    int numberofMatches();
    // sorts teams
     Team[] standings() ;
    void printStandings();
    
   
    
}
class Team implements Comparable<Team>{
    String name;
int wins;
int losses;
int draws;
int points;
int numberofGames;
int goalsScored;
int goalsConceded;
int goalDifference;
MatchMapInterface m;
void calcGD()
{
 goalDifference=goalsScored-goalsConceded;
}
//create team with no previous record
public Team(String name) throws Exception {
   
    this(name,0,0,0,0,0);
    
}
//create team with previous record
//assume user knows format to enter (String int int int int int int int)
    public Team(String name, int wins, int losses, int draws, int goalsScored, int goalsConceded) throws Exception
    {
        if(name==null||name.contains("#")||name.contains("@")||name.length()>30){
    throw new Exception("team name shouldn't be null or contain # or @");
        }
        
        if(wins<0||losses<0||draws<0||goalsScored<0||goalsConceded<0){
        throw new Exception("team stats cannot be negative (except goal difference)");
        }
        else{
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        points=wins*3+draws;
        numberofGames= wins+losses+draws;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        calcGD();
        m = new MatchMapImplementation();
    }
    }
        
    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getPoints() {
        return points;
    }

    public int getNumberofGames() {
        return numberofGames;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

  

    
    public int compareTo(Team otherTeam) {
       
        if (this.points != otherTeam.points) {
            return Integer.compare(otherTeam.points, this.points);
        } else if (this.wins != otherTeam.wins) {
            return Integer.compare(otherTeam.wins, this.wins);
        } else if (this.goalDifference != otherTeam.goalDifference) {
            return Integer.compare(otherTeam.goalDifference, this.goalDifference);
        } else if (this.goalsScored != otherTeam.goalsScored) {
            return Integer.compare(otherTeam.goalsScored, this.goalsScored);
        } else if (this.numberofGames != otherTeam.numberofGames) {
            return Integer.compare(this.numberofGames, otherTeam.numberofGames);
        } else {
           
            return this.name.compareToIgnoreCase(otherTeam.name);
        }
    }
 

    @Override
    public String toString()
    {
        return String.format("%s %dp, %dg (%d-%d-%d), %dgd (%d-%d)",name,points,numberofGames,wins,draws,losses,goalDifference,goalsScored,goalsConceded);
    
}
}







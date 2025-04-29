package tournament;
import Dictionary.Implementations.Sorted.SortedVector.SortedVectorDictionary; //local dictionary package 
import java.util.logging.Level;
import java.util.logging.Logger;
import SortArray.Iterative.ArraySorter;
import java.util.Iterator;

public class TournamentImplementation  extends SortedVectorDictionary<String,Team> implements TournamentInterface<String,Team>
{
   private MatchMapImplementation matchMap;
   public String name;
   

    public TournamentImplementation(String name,int numberofMatches) 
    {
        
        super();
        this.name=name;
        try
        {
            matchMap= new MatchMapImplementation(numberofMatches);
        } catch (Exception ex)
        {
            Logger.getLogger(TournamentImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    public TournamentImplementation(String name,int initialCapacity, int numberofMatches) throws Exception
    {
        super(initialCapacity);
        this.name=name;
        if(initialCapacity>30)
        {
            throw new Exception("There can only be 30 teams at most in a single tournament");
        }
        matchMap  = new MatchMapImplementation(numberofMatches);
        
    }
    public void addTeam(String name)
    {
       try
       {
           Team team = new Team(name);
           addTeam(name,team);
       } catch (Exception ex)
       {
           Logger.getLogger(TournamentImplementation.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    public void addTeam(String name,Team team)  {
        
   {
     if (super.contains(name))
    {
        System.out.println("Team Info Updated");
        super.add(name, team);
            
    }
   else if(super.getSize()>=30)
    {
       System.out.println("There can only be 30 teams at most in a single tournament"); 
    }
    else 
   {
       super.add(name, team);
    
     
    
    
    }
        }
    }
  
    public void addMatch (String match) {
    // to add match to tournament matchmap
    matchMap.addMatch(match);
    Match M =  matchMap.getValue(match);
    Team team1 =super.getValue(M.team1);
    Team team2 = super.getValue(M.team2);
    //to add match to each team's matchmap
    team1.m.addMatch(match);
    team2.m.addMatch(match);
    int team1Goals=M.team1Goals;
    int team2Goals=M.team2Goals;
            if(team1Goals>=0&&team1Goals<20&&team2Goals>=0&&team2Goals<20){
    team1.goalsScored+=team1Goals;
    team1.goalsConceded+=team2Goals;
    team1.numberofGames++;
    team2.goalsScored+=team2Goals;
    team2.goalsConceded+=team1Goals;
    team2.numberofGames++;
    team1.calcGD();
    team2.calcGD();
    if(team1Goals>team2Goals)
    {
        team1.points+=3;
        team1.wins++;
        team2.losses++;
    }
    else if(team1Goals<team2Goals)
    {
        team2.points+=3;
        team2.wins++;
        team1.losses++;
    }
    else{
        team1.draws++;
        team1.points++;
        team2.draws++;
        team2.points++;
    }
    
    }
        else{
        System.out.println("Match:" + match+ " not saved, Goals Scored must be 20 at most and 0 at least");
        }
    }
    public int numberofMatches()
    {
        return matchMap.getSize();
    }
  
  
     public Team[] standings() {
        Team[] teams = new Team[super.getSize()];
        Iterator<Team> valueIterator = super.getValueIterator();
        int i = 0;
        while (valueIterator.hasNext()) {
            teams[i] = valueIterator.next();
            i++;
        }
        ArraySorter.selectionSort(teams, teams.length);
        return teams;
    }
     public void printStandings()
     {
            Team[] standings = standings();
            for(int i = 0; i<standings.length;i++)
            {
                System.out.println(standings[i]);
            }
         
     }
     public  String printTournament()
     {
           System.out.println(name);
            Team[] standings = standings();
            
            String s = "";
            for(int i = 0; i<standings.length;i++)
            {
               s+=standings[i]+"\n";
               
            }
            return s;
         
     }

    @Override
    public String toString()
    {
        return printTournament();
    }
     
}
  
   

  

  
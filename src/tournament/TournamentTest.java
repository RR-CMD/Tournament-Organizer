package tournament;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TournamentTest 
{

  
    public static void main(String[] args) 
    {
        
       
        try
        {
             TournamentMapImplementation TMAP = new TournamentMapImplementation(2);
        TournamentImplementation T1;
            T1 = new TournamentImplementation("World Cup 1998 - Group A",4,6);
        
        T1.addTeam("Brazil",new Team("Brazil"));
        T1.addTeam("Norway",new Team("Norway"));
        T1.addTeam("Morocco",new Team("Morocco"));
        T1.addTeam("Scotland",new Team("Scotland"));
        T1.addMatch("Brazil#2@1#Scotland");
        T1.addMatch("Norway#2@2#Morocco");
        T1.addMatch("Scotland#1@1#Norway");
        T1.addMatch("Brazil#3@0#Morocco");
        T1.addMatch("Morocco#3@0#Scotland");
        T1.addMatch("Brazil#1@2#Norway");
        TMAP.addTournament( T1);
        TMAP.printAll();
        
        
        } catch (Exception ex)
        {
            Logger.getLogger(TournamentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

}

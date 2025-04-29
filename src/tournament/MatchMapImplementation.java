package tournament;
import Dictionary.Implementations.Sorted.SortedVector.SortedVectorDictionary;
public class MatchMapImplementation extends SortedVectorDictionary<String,Match> implements MatchMapInterface<String,Match>
{

    public MatchMapImplementation()
            
    {
        super();
       
    }

    public MatchMapImplementation(int initialCapacity) throws Exception
    {
        super(initialCapacity);
        if(initialCapacity>1000)
        {
            throw new Exception("The number of matches in a single tournament must be 1000 at most");
        }
    }

    
    public int numberofMatches()
    {
        return super.getSize();
    }

    
    public void addMatch(String match) 
    {
       
        
        //regular expression to check input follows: team1#goals1@goals2#team2
       /*
        [^\x00-\x1F]+ any characters not(^) in range(0-31) will be accepted, x00,x1F hexadecimal->0-31 decimal
        note: if the string contains # and @ will be checked later
        # seperates String and int
        //d+ 1 or more digit
        @ seperates int 1 and int 2
        () around each part so we can split it match later
        */
        String regex = "([^\\x00-\\x1F]+)#(\\d+)@(\\d+)#([^\\x00-\\x1F]+)";
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(regex).matcher(match);
        if(!matcher.matches())
        {
        System.out.println("Match: "+match+" not saved, should be written in the following format: team1name#team1goals@team2goals#team2name");
        }
        else{
       String team1 = matcher.group(1);
    int team1Goals = Integer.parseInt(matcher.group(2));
    int team2Goals = Integer.parseInt(matcher.group(3));
    String team2 = matcher.group(4);
    Match M = new Match(team1,team1Goals,team2Goals,team2);
    super.add(match, M);
        
    }
        
    }
}



  
   
    



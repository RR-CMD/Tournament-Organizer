package tournament;
import Dictionary.Implementations.Sorted.SortedVector.SortedVectorDictionary; //local dictionary package 
import java.util.logging.Level;
import java.util.logging.Logger;
import SortArray.Iterative.ArraySorter;
import java.lang.String;
import java.util.Iterator;
public class TournamentMapImplementation extends SortedVectorDictionary<String,TournamentInterface> implements TournamentMapInterface
{

    public TournamentMapImplementation()
    {
        super();
    }

    public TournamentMapImplementation(int initialCapacity)
    {
        super(initialCapacity);
    }
    public void addTournament(TournamentImplementation T)
    {
        super.add(T.name,T);
    }
    
    public void printAll()
    {
        TournamentInterface[] tourneys = new TournamentInterface[super.getSize()];       
        Iterator<TournamentInterface> valueIterator = super.getValueIterator();
        int i = 0;
        
        while (valueIterator.hasNext()) {
            tourneys[i] = valueIterator.next();
            System.out.println(tourneys[i]);
            i++;
        }
        
      
    
    
    
   
    
}

   

 
    
}

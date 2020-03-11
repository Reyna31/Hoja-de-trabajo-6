import java.util.Map;
import java.util.*;

public class FactoryMap {
    public Map FactoryCards(String typeSet){
        if(typeSet.equals("HashMap")){
            return new HashMap();
        }
        if (typeSet.equals("TreeMap")){
            return new TreeMap();
        }
        if (typeSet.equals("LinkedMap")){
            return new LinkedHashMap();
        }
        return null;
    }
}

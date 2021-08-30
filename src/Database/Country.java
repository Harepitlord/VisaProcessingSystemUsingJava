package Database;
import java.util.*;
public class Country {
   private static final String[] countries ={"Select","Afghanistan","Australia","Canada","Germany","Japan","Sweden","Switzerland","Thai Land","United Kingdom","United States of America"};
   static HashMap<String,String[]> mission =new HashMap<>();
    static{
        String[] afg ={"Herat","Kabul","Kandhar"};
        mission.put("Afghanistan",afg);
        String[] aus ={"Canderra","Perth","Sydney"};
        mission.put("Australia",aus);
        String[] can ={"Ottawa","Torondo","Vancouver"};
        mission.put("Canada",can);
        String[] ger ={"Berlin","FrankFurt","Hamburg"};
        mission.put("Germany",ger);
        String[] jap ={"Kobe","Tokyo"};
        mission.put("Japan",jap);
        String[] uk ={"Birmingham","Edinburgh","London"};
        mission.put("United Kingdom",uk);
        String[] usa ={"Atlanta","NewYork","Washington"};
        mission.put("United States Of America",usa);
        String[] swe ={"StockHolm"};
        mission.put("Sweden",swe);
        String[] swz ={"Berne","Geneva"};
        mission.put("Switzerland",swz);
        String[] tha ={"Banckok","Chiangmai"};
        mission.put("Thai Land",tha);
    }

    public static String[] getCountries() {
        return countries;
    }

    public static String[] getMission(String s) {
        return mission.get(s);
    }

}

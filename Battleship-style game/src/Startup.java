import java.util.ArrayList;

public class Startup {

    private ArrayList<String> locationCells;
//    int numOfHits = 0;
    private String name;

    public Startup(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }

        return result;
    }

    public void setLocationCells(ArrayList<String> locations) {
        this.locationCells = locations;
    }
}

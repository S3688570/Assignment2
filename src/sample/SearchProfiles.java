package sample;

/**
 * SearchProfiles class. (For outputing a person's profile).
 *
 * @author cgalea
 */
public class SearchProfiles extends TextDatabase {

    private String searchPersonName;

    /**
     * Default constructor.
     */
    public SearchProfiles() {
    }

    /**
     * Method to select person's profile
     */
    public Person searchName() throws MyExceptions {
        //Input person's name
        boolean error = false;
        do {
            if (!searchPersonName.matches("[a-zA-Z ]+")) {
                error = true;
                throw new MyExceptions("Incorrect input");
            } else {
                error = false;
            }
        } while (error == true);

        boolean person = false;
        for (int i = 0; i < people.size(); i++) {
            if (searchPersonName.equalsIgnoreCase(people.get(i).getName())) {
                person = true;
            }
        }
        if (person == false) {
            System.out.println("This person is not in this database");
        }

        //Print profile for selected person
        for (int i = 0; i < people.size(); i++) {
            if (searchPersonName.equalsIgnoreCase(people.get(i).getName())) {
                return people.get(i);
            }
        }
        return null;
    }
}


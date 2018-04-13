import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents the register of newspaper.
 *
 * @author Nikita Sumahers, Sarmad Abbas and Kristin Hagen
 * @version 2018-02-12
 */
public class Register {

    private ArrayList<Literature> literatureList;

    /**
     * Constructor for objects of class Register.
     */
    public Register() {
        this.literatureList = new ArrayList<Literature>();
    }

    /**
     * Adds a newspaper to the register
     *
     * @param newspaper - the newspaper to add to the register
     */
    public void addLiterature(Literature literature) {
        this.literatureList.add(literature);
    }

    /**
     * Removes a newspaper by its index from the register
     *
     * @param index - the index of the newspaper to remove from the register
     */
    public void removeLiteratureByIndex(int index) {
        this.literatureList.remove(index);
    }

    /**
     * Searches and returns for all newspapers that contain a given string in
     * their title
     *
     * @param title - the string of the newspaper to remove from the register
     */
    public Literature getLiteratureByTitle(String title) {
        Literature foundLiterature = null;
        int index = 0;
        while ((null == foundLiterature) && (index < this.literatureList.size())) {
            Literature p = this.literatureList.get(index++);
            if (p.getTitle().contains(title)) {
                foundLiterature = p;
            }
        }
        return foundLiterature;
    }

    /**
     * Removes all newspapers that contain a given string in their title from
     * the register
     *
     * @param title - the string of the newspaper to remove from the register
     */
    public void removeByTitleContains(String titleToRemove) {
        Iterator<Literature> it = literatureList.iterator();
        while (it.hasNext()) {
            Literature t = it.next();
            String title = t.getTitle();
            if (title.contains(titleToRemove)) {
                it.remove();
            }
        }
    }
    
    /**
     * Lists all persons in the phone book to the terminal window.
     */
    public Iterator<Literature> getLiteraureIterator() {
        return this.literatureList.iterator();
    }

    /**
     * Adds some newspaper to the register.
     */
    public void fillLiteratureRegister() {
        literatureList.add(new Newspaper(78 ,"VG Avis", "Publiseringslaget - VG", "Sport", "NO", "31.07.2001", 365));
        literatureList.add(new Book("Objects first with java", "Pearson", "Programming", "EN", "02.10.2017","8th", "global edition", 630));
        literatureList.add(new Booklet("Ordliste", "English learner", "School", "EN", "21.07.2012", 14));
        literatureList.add(new Magazine(9 ,"Topp bladet", "Publiseringslaget - topp", "Sport", "NO", "31.07.2001", 26));
    }
}
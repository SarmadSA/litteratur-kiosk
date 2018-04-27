import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents the register of literature,
 * the register stores all avalible literature.
 * 
 * @author Sarmad, Nikita and Kristin
 * @version 2018.04.14
 */
public class Register {

    private final ArrayList<Literature> literatureList;

    /**
     * Constructor for objects of class Register.
     */
    public Register() {
        this.literatureList = new ArrayList<>();
    }

    /**
     * Adds a literature to the register
     *
     * @param literature - the newspaper to add to the register
     */
    public void addLiterature(Literature literature){
        this.literatureList.add(literature);
    }

    /**
     * Removes a newspaper by its index from the register
     *
     * @param index - the index of the literature to remove from the register
     */
    public void removeLiteratureByIndex(int index) {
        this.literatureList.remove(index);
    }

    /**
     * Searches and returns all literature that contain a given string in
     * the title.
     *
     * @param title - the title of the literature to find from the register
     * @return return the found literature that contains the given string
     */
    public Literature getLiteratureByTitle(String title) {
        Literature foundLiterature = null;
        int index = 0;
        while ((null == foundLiterature) && (index < this.literatureList.size())) {
            Literature p = this.literatureList.get(index++);
            if (p.getTitle().toLowerCase().contains(title)) {
                foundLiterature = p;
            }
        }
        return foundLiterature;
    }
    
    /**
     * Searches and returns all literature that contain a given text in
     * the publisher field.
     *
     * @param publisher - the publisher of the literature to find from the register
     * @return return the found literature that contains the given string
     */
    public Literature getLiteratureByPublisher(String publisher) {
        Literature foundLiterature = null;
        int index = 0;
        while ((null == foundLiterature) && (index < this.literatureList.size())) {
            Literature p = this.literatureList.get(index++);
            if (p.getPublisher().toLowerCase().contains(publisher)) {
                foundLiterature = p;
            }
        }
        return foundLiterature;
    }

    /**
     * Removes all literature that contain a given string in their title from
     * the register
     *
     * @param titleToRemove the title of the literature to remove from the register
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
     * Return iteratore of literature that is added to the register
     * 
     * @return iteratuor of literature arraylist
     */
    public Iterator<Literature> getLiteraureIterator() {
        return this.literatureList.iterator();
    }

    /**
     * Fills register with some literature.
     */
    public void fillLiteratureRegister() {
        literatureList.add(new Newspaper(78 ,"VG Avis", "Publiseringslaget - VG", "Sport", "NO", "31.07.2001", 365));
        literatureList.add(new Book("Objects first with java", "Pearson", "Programming", "EN", "02.10.2017", 630));
        literatureList.add(new Booklet("Ordliste", "English learner", "School", "EN", "21.07.2012", 14));
        literatureList.add(new Magazine(9 ,"Topp bladet", "Publiseringslaget - topp", "Sport", "NO", "31.07.2001", 26));
    }
    
    /**
     * Sets/Changes literature series states to a new state.
     * 
     * @param literature the literature to set series state of. 
     * @param state the state to set literature series state to.
     */
    public void seLiteratureSeriesState(Literature literature, boolean state){
        Book l1 = (Book) literature;
        l1.setSeries(state);
    }
    
    /**
     * Returns ture if register is emptym false otherwise.
     * 
     * @return ture if regiser is empty, false otherwise
     */
    public boolean isEmpty(){
        return literatureList.size() <= 0 ;
    }
}
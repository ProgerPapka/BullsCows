package game.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserIdea implements Serializable, Iterable<String>{

    private List<String> userValues = new ArrayList<>();

    public UserIdea() {
    }

    public List<String> getUserValues() {
        return userValues;
    }

    public void addValue(String v){
        userValues.add(v);
    }

    public int size(){
        return userValues.size();
    }

    @Override
    public Iterator<String> iterator() {
        return userValues.iterator();
    }
}

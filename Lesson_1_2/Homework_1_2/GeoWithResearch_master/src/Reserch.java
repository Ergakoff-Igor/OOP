import java.util.ArrayList;
import java.util.HashSet;

public class Reserch {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> tree;

    public Reserch(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    /**
     * Получить родственников person с отношением re
     */
    public ArrayList<String> spend(Person person, Relationship re) {
        for (Node t : tree) {
            if (t.getP1().getFullName().equals(person.getFullName()) && t.getRe() == re) {
                result.add(t.getP2().getFullName());
            }
        }
        return result;
    }

   
    /**
     * Получить братьев и сестер
     */
    public ArrayList<String> brotherSister(Person person) {
        ArrayList<Node> parents = new ArrayList<>();
        for (Node parent : this.tree) {
            if (parent.getRe() == Relationship.parent && parent.getP2().equals(person)) {
                parents.add(parent);
                if (parents.size() > 1) break;
            }
        }
        HashSet<Person> brother_sister = new HashSet<>();
        for (Node parent : parents) {
            for (Node t : this.tree) {
                if (parent.getP1().equals(t.getP1()) &&
                        t.getRe() == Relationship.parent && 
                        !t.getP2().equals(person)) {
                    brother_sister.add(t.getP2());
                }
            }
        }
        for (Person p : brother_sister) {
            result.add(p.getFullName());
        }
        return result;

    }

    /**
     * Получить бабушек и дедушек
     */
    public ArrayList<String> grand(Person person) {
        ArrayList<Node> parents = new ArrayList<>();
        for (Node parent : this.tree) {
            if (parent.getRe() == Relationship.parent && parent.getP2().equals(person)) {
                parents.add(parent);
                if (parents.size() > 1) break;
            }
        }
        HashSet<Person> grand = new HashSet<>();
        for (Node parent : parents) {
            for (Node t : this.tree) {
                if (parent.getP1().equals(t.getP1()) &&
                        t.getRe() == Relationship.children) {
                            grand.add(t.getP2());
                }
            }
        }
        for (Person p : grand) {
            result.add(p.getFullName());
        }
        return result;

    }    


}

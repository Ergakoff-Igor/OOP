import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Reserch implements ActionReserch {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> tree;

    public Reserch(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    /**
     * Получить родственников person с отношением re
     */
    @Override
    public ArrayList<String> spend(Person person, Relationship re) {
        Iterator<Node> iter = tree.iterator();
        while (iter.hasNext()) {
            Node next = iter.next();
            if (next.getP1().getFullName().equals(person.getFullName()) &&
                    next.getRe() == re) {
                result.add(next.getP2().getFullName());
            }
        }
        return result;

    }

    @Override
    public ArrayList<String> brothers_sisters(Person person, Relationship re1, Relationship re2) {
        ArrayList<Node> parents = new ArrayList<>();
        for (Node parent : this.tree) {
            if (parent.getRe() == Relationship.parent && parent.getP2().equals(person)) {
                parents.add(parent);
                if (parents.size() > 1)
                    break;
            }
        }
        HashSet<Person> brother_sister = new HashSet<>();
        for (Node parent : parents) {
            Iterator<Node> iter = tree.iterator();
            while (iter.hasNext()) {
                Node next = iter.next();
                if (next.getP2().equals(person)) {
                    iter.remove();
                } else if (parent.getP1().equals(next.getP1()) &&
                        next.getRe() == Relationship.parent) {
                    brother_sister.add(next.getP2());
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
    @Override
    public ArrayList<String> grand(Person person) {
        for (Node parent : this.tree) {
            if (parent.getRe() == Relationship.parent && parent.getP2().equals(person)) {
                result = spend(parent.getP1(), Relationship.children);
            }
        }
        return result;
    }

    /*
     * вывести всех членов семьи, и отсортировать по году рождения
     */
    @Override
    public TreeSet<Person> allRelatives() {
        Comparator<Person> pcomp = new PersonYearComparator().thenComparing(new PersonNameComparator());
        TreeSet<Person> people = new TreeSet<>(pcomp);
        for (Node person : tree) {
            people.add(person.getP1());
        }
        return people;
    }
}

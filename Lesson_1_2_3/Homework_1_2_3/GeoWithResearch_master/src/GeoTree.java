import java.util.ArrayList;

class GeoTree implements ActionGeoTree {
    private final ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    @Override
    public void append(Person parent, Person children) {
        if (checkPerson(parent, children)) { 
            return;
        }
        tree.add(new Node(parent, Relationship.parent, children)); 
        tree.add(new Node(children, Relationship.children, parent)); 
    }

    @Override
    public boolean replaceChildren(Person person, Person newChildren, Person oldChildren) {
        if (checkPerson(person, newChildren)) return false;
        for (Node t : tree) {
            if (t.getP1().equals(person) &&
                    Relationship.children == t.getRe() &&
                    t.getP2().equals(oldChildren)) {
                t.setP2(newChildren);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPerson(Person person1, Person person2) {
        return (person1 == null || person2 == null);
    }
}

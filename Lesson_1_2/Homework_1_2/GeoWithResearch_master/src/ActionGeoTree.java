public interface ActionGeoTree {
    void append(Person parent, Person children);
    boolean replaceChildren(Person person, Person newChildren, Person oldChildren);
    boolean checkPerson(Person person1, Person person2);  
}

package entity;

import javax.persistence.*;

@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name = "firstname_fk", referencedColumnName = "firstname"),
            @JoinColumn(name = "lastname_fk", referencedColumnName = "lastname")
    })
    private Parent parent;

    public Child() {
    }

    public Child(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}

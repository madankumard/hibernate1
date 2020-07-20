package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ElementCollection
    @CollectionTable(name = "friend_nickname", joinColumns = @JoinColumn(name = "friend_id"))
    @Column(name = "nickname")
    private Collection<String> nicknames = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "friend_address", joinColumns = @JoinColumn(name = "friend_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "friend_street")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "friend_zipcode")),
            @AttributeOverride(name = "city", column = @Column(name = "friend_city"))
    })
    private Collection<Address> addresses = new ArrayList<>();

    public Friend() {
    }

    public Friend(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Collection<String> getNicknames() {
        return nicknames;
    }

    public void setNicknames(Collection<String> nicknames) {
        this.nicknames = nicknames;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nicknames=" + nicknames +
                '}';
    }
}

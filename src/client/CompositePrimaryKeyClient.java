package client;

import entity.Parent;
import entity.ParentPrimaryKey;
import org.hibernate.Session;
import util.HibernateUtil;

public class CompositePrimaryKeyClient {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        //persisting
        ParentPrimaryKey parentPrimaryKey = new ParentPrimaryKey("Gavin", "King");
        Parent parent = new Parent(parentPrimaryKey);
        session.persist(parent);

        session.getTransaction().commit();
        session.close();
    }
}

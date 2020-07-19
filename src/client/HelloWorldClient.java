package client;

import entity.Message;
import org.hibernate.Session;
import util.HibernateUtil;

public class HelloWorldClient {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        //Save
        //Message message = new Message("Hello World");
        //session.save(message);

        //Get
        //Message message = session.get(Message.class, 2L);
        //System.out.println(message);

        //Update
        Message message = session.get(Message.class, 3L);
        message.setText("Automatic Dirty Check 2");

        //Delete
        message = session.get(Message.class, 4L);
        session.delete(message);

        session.getTransaction().commit();
        session.close();
    }
}

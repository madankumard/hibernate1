package client;

import entity.Address;
import entity.Message;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class HelloWorldClient {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction txn = session.getTransaction();

        try{
            txn.begin();
            Address homeAddress = new Address("200 E Main St", "Seattle", "345345");
            Address billingAddress = new Address("100 E Main St", "Seattle2", "245345");
            Person person = new Person("ruby", homeAddress, billingAddress);
            session.save(person);
            txn.commit();
        }catch (Exception e){
            if(txn != null) txn.rollback();
            e.printStackTrace();
        }finally {
            if(session!=null) session.close();
        }




        //Save
        //Message message = new Message("Hello World");
        //session.save(message);

        //Get
        //Message message = session.get(Message.class, 2L);
        //System.out.println(message);

        //Update
        //Message message = session.get(Message.class, 3L);
        //message.setText("Automatic Dirty Check 2");

        //Delete
        //message = session.get(Message.class, 4L);
        //session.delete(message);

        //session.getTransaction().commit();
        //session.close();
    }
}

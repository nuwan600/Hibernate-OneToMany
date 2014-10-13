/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nuwan600
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*Person p1 = new Person();
        p1.setName("Saman");
        p1.setAge(22);
        createPerson(p1);
        Person p2 = new Person();
        p2.setName("Peter");
        p2.setAge(31);
        createPerson(p2);
        listPerson();
        p1.setAge(44);
        updatePerson(p1);
        p2.setName("Peter John");
        updatePerson(p2);
        listPerson();*/
        Person p1 = new Person();
p1.setName("Saman With Hats");
p1.setAge(30);
Hat h1 = new Hat();
h1.setColor("Black");
h1.setSize("Small");
Hat h2 = new Hat();
h2.setColor("White");
h2.setSize("Large");
p1.addHat(h1);
p1.addHat(h2);
createPerson(p1);
listPerson();
        
        
    }
    
    private static void listPerson() {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try {
        tx = session.beginTransaction();
        List persons = session.createQuery(
        "select p from Person as p").list();
        System.out.println("*** Content of the Person Table ***");
        System.out.println("*** Start ***");
        for (Iterator iter = persons.iterator(); iter.hasNext();) {
        Person element = (Person) iter.next();
        System.out.println(element);
        }
        System.out.println("*** End ***");
        tx.commit();
    } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
            try {
                // Second try catch as the rollback could fail as well
                tx.rollback();
            } catch (HibernateException e1) {
                System.out.println("Error rolling back transaction");
            }
                throw e;
            }
        }
    }
    
    
    private static void deletePerson(Person person) {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.delete(person);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");

                }
            }
            // throw again the first exception
            throw e;
        }
    }
    
    private static void createPerson(Person person) {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                    // throw again the first exception
                    throw e;
            }
        }
    }
    
    private static void updatePerson(Person person) {
Transaction tx = null;
Session session = SessionFactoryUtil.getCurrentSession();
try {
tx = session.beginTransaction();
session.update(person);
tx.commit();
} catch (RuntimeException e) {
if (tx != null && tx.isActive()) {
try {
// Second try catch as the rollback could fail as well
tx.rollback();
} catch (HibernateException e1) {
System.out.println("Error rolling back transaction");
}
// throw again the first exception
throw e;
}
}
}
    
    
}

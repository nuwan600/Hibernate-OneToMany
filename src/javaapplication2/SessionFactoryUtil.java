/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

/**
 *
 * @author nuwan600
 */
public class SessionFactoryUtil {
    
    private static final SessionFactory sessionFactory;
    static {
        try {
        // Create the SessionFactory from standard (hibernate.cfg.xml)
        // config file.
            sessionFactory = new AnnotationConfiguration().configure()
            .buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed."
            + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    /**
* Opens a session and will not bind it to a session context
* @return the session

public static Session openSession() {
return sessionFactory.openSession();
}
/**
* Returns a session from the session context.
* If there is no session in the context it opens a session,
* stores it in the context and returns it.
* This factory is intended to be used with a hibernate.cfg.xml
* including the following property <property
* name="current_session_context_class">thread</property>
* This would return
* the current open session or if this does not exist, will create a new
* session
*
* @return the session

public static Session getCurrentSession() {
return sessionFactory.getCurrentSession();
}

public static void close(){
if (sessionFactory != null)
sessionFactory.close();
}
    */
}

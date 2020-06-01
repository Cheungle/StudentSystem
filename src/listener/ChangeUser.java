package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class ChangeUser
 *
 */
@WebListener
public class ChangeUser implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public ChangeUser() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	HttpSession session = se.getSession();
    	String name =se.getName();
    	Object old = se.getValue();
    	if( name.equals("username")) {
    		if(old!="")System.out.println("user "+old+" log out");
    		if(session.getAttribute("username")!="")System.out.println("user "+session.getAttribute("username")+" log in.");
    	} 
    		
    }
	
}

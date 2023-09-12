package CoreApplication;

import java.io.Serializable;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Employee implements Serializable {

   private static final long serialVersionUID = 1L;
   @XmlElement(name = "id")
   private Integer id;
   @XmlElement(name = "firstName")
   private String firstName;
   @XmlElement(name = "lastName")
   private String lastName;
   @XmlElement(name = "department")
   private String department;

   public Employee() {
       super();
   }

   //Setters and Getters

   @Override
   public String toString() {
       return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
               + department + "]";
   }

   // It is called immediately after the object is created and before the unmarshalling begins.
   // The callback provides an opportunity to initialize JavaBean properties prior to unmarshalling.
   void beforeUnmarshal(Unmarshaller unmarshaller, Object parent) {
       System.out.println("Before Unmarshaller Callback");
   }

   // It is called after all the properties are unmarshalled for this object,
   // but before this object is set to the parent object.
   void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
       System.out.println("After Unmarshaller Callback");
   }
}

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
public class AppTest {
        @Test
        void testAddContact() {
                ContactService service = new ContactService();
                Contact c = new Contact(1, "Madhu", "madhu@gmail.com", "123");
                assertTrue(service.addContact(c));
                assertFalse(service.addContact(c)); // duplicate
        }
        @Test
        void testGetContact() {
                ContactService service = new ContactService();
                Contact c = new Contact(1, "Madhu", "madhu@gmail.com", "123");
                service.addContact(c);
                assertNotNull(service.getContact(1));
                assertEquals("Madhu", service.getContact(1).getName());
        }
        @Test
        void testUpdateContact() {
                ContactService service = new ContactService();
                Contact c1 = new Contact(1, "Madhu", "madhu@gmail.com", "123");
                service.addContact(c1);
                Contact updated = new Contact(1, "Madesh", "madesh@gmail.com", "999");assertTrue(service.updateContact(1, updated));
                assertEquals("Madesh", service.getContact(1).getName());
        }
        @Test
        void testDeleteContact() {
                ContactService service = new ContactService();
                Contact c = new Contact(1, "Madhu", "madhu@gmail.com", "123");
                service.addContact(c);
                assertTrue(service.deleteContact(1));
                assertNull(service.getContact(1));
        }
}

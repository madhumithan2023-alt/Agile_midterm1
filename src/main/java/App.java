import java.util.HashMap;
import java.util.Map;

// Model Class
class Contact {
    private int id;
    private String name;
    private String email;
    private String phone;

    public Contact(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
}

// Service Class
class ContactService {
    private Map<Integer, Contact> contacts = new HashMap<>();

    // CREATE
    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getId())) return false;
        contacts.put(contact.getId(), contact);
        return true;
    }

    // READ
    public Contact getContact(int id) {
        return contacts.get(id);
    }

    // UPDATE
    public boolean updateContact(int id, Contact newContact) {
        if (!contacts.containsKey(id)) return false;
        contacts.put(id, newContact);
        return true;
    }

    // DELETE
    public boolean deleteContact(int id) {
        if (!contacts.containsKey(id)) return false;
        contacts.remove(id);
        return true;
    }
}

// Main Class
public class App {
    public static void main(String[] args) {
        ContactService service = new ContactService();

        Contact c1 = new Contact(1, "Madhu", "madhu@gmail.com", "9876543210");

        service.addContact(c1);

        System.out.println("Added: " + service.getContact(1).getName());

        service.deleteContact(1);

        System.out.println("After Delete: " + service.getContact(1));
    }
}
public class ContactsManager {
    private Contact[] contacts;
    private int contactCounter;

    // default constructor
    ContactsManager() {
        this.contactCounter = 0;
        this.contacts = new Contact[500];
    }

    public void addContact(Contact contact) {
        contacts[contactCounter++] = contact;
    }

    public Contact searchContact(String searchName) {
        for (int i = 0; i < contactCounter; i++) {
            if (contacts[i].getName().equals(searchName)) {
                return contacts[i];
            }
        }
        return null;
    }
}

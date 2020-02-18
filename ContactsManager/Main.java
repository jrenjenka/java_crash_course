public class Main {
    public static void main(String[] args) {
        ContactsManager myContactsManager = new ContactsManager();
        Contact friend1 = new Contact("Daniel", "daniel@email.com", "0044124676609");
        Contact friend2 = new Contact("Charles", "charles@email.com", "00126898978979");
        Contact friend3 = new Contact("Alfred", "alfred@email.com", "00441246780909");

        myContactsManager.addContact(friend1);
        myContactsManager.addContact(friend2);
        myContactsManager.addContact(friend3);

        System.out.println(myContactsManager.searchContact("Charles").getEmail());
    }
}

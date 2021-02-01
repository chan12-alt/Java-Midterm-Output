package midterms;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Midterms {
    public static void main(String[] args) {
        ArrayList<Entries> collectInput = new ArrayList<>();
        mainMenu(collectInput);
    }
    public static void addItem(ArrayList<Entries> collectInput){
        //Add entry
        String a = JOptionPane.showInputDialog("How many entries would you like to add?");
        int add = Integer.parseInt(a);
        for(int i = 0; i < add; i++){
            Entries newRecord = new Entries(null, null);
            newRecord.setName(JOptionPane.showInputDialog("Input name:"));
            newRecord.setAge(JOptionPane.showInputDialog("Input age:"));
            
            collectInput.add(newRecord);
        }
        mainMenu(collectInput);
    }
    public static void deleteItem(ArrayList<Entries> collectInput){
        //Delete entry
        String d = JOptionPane.showInputDialog("       What entry would you like to delete?" 
        + "\n" + "1. Delete an entry" + "\n" + "2. Delete all saved entries" + "\n" + "3. Go back");
        int delete = Integer.parseInt(d);
        switch(delete){
            case 1://Deletes an entry
                String sentence = "";
                int input = 1;
                for(Entries r : collectInput){
                    String data1 = r.getName();
                    String data2 = r.getAge();
                    sentence += "\n" + input + ". " + data1 + " is " + data2;
                    input++;
                }
                String del1 = JOptionPane.showInputDialog("       List of Persons" + sentence + "\n\n" +
                        "Choose an entry you want to delete:");
                int index = Integer.parseInt(del1) - 1;
                
                collectInput.remove(index);
                
                JOptionPane.showMessageDialog(null, "Successfully deleted!");
                break;
            case 2://Deletes all entries
                String del2 = JOptionPane.showInputDialog("       Are you sure you want to delete all saved entries?" 
                + "\n" + "1. Yes" + "\n" + "2. No" + "\n\n" + "Enter number:");
                int num2 = Integer.parseInt(del2);
                switch(num2){
                    case 1://Yes(Clears all entries)
                        collectInput.clear();
                        
                        JOptionPane.showMessageDialog(null, "Entries are successfully deleted!");
                        break;
                    case 2://No(Goes backsto deleteItem())
                        deleteItem(collectInput);
                        break;
                }
                break;
            case 3://Goes back to mainMenu()
                mainMenu(collectInput);
        }
        mainMenu(collectInput);
    }
    public static void viewItem(ArrayList<Entries> collectInput){
        //View entry
        String sentence = "";
        int input = 1;
        for(Entries r : collectInput){
            String data1 = r.getName();
            String data2 = r.getAge();
            sentence += "\n" + input + ". " + data1 + " is " + data2;
            input++;
        }
        JOptionPane.showMessageDialog(null, "       List of Persons" + sentence);
        
        mainMenu(collectInput);
    }
    public static void updateItem(ArrayList<Entries> collectInput){
        //Update entry
        String sentence = "";
        int input = 1;
        for(Entries r : collectInput){
            String data1 = r.getName();
            String data2 = r.getAge();
            sentence += "\n" + input + ". " + data1 + " is " + data2;
            input++;
        }
        String u = JOptionPane.showInputDialog("       List of Persons" + sentence + "\n\n" +
                "Choose an entry to change:");
        int index = Integer.parseInt(u) - 1;
        collectInput.get(index).setName(JOptionPane.showInputDialog("Enter new name:"));
        collectInput.get(index).setAge(JOptionPane.showInputDialog("Enter new age:"));
        
        mainMenu(collectInput);
    }
    public static void mainMenu(ArrayList<Entries> collectInput){
        //Main menu
        String m = JOptionPane.showInputDialog("                         Home" + "\n"
        + "       1. Add Entry" + "\n" + "       2. Delete Entry" + "\n" + "       3. View Entries"
        + "\n" + "       4. Update Entries" + "\n" + "       5. Exit" + "\n\n" + "Select option:");
        int option = Integer.parseInt(m); 
        switch(option){
            case 1:
                addItem(collectInput);
                break;
            case 2:
                deleteItem(collectInput);
                break;
            case 3:
                viewItem(collectInput);
                break;
            case 4:
               updateItem(collectInput);
                break;
            case 5:
                System.exit(0);
        }
    }    
}

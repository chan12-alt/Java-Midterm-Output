package midterms;
public class Entries {
    private String name;
    private String age;
    
    public Entries(String name, String age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAge(){
        return this.age;
    }
    public void setAge(String age){
        this.age = age;
    }
}

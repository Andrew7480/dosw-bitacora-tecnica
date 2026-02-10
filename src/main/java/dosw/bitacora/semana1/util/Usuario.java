package dosw.bitacora.semana1.util;

public class Usuario {
    private String id;
    private String name;
    private int age;
    private boolean active;


    public Usuario(String id, String name, int age, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public boolean isActive() {
        return active;
    }
    
}

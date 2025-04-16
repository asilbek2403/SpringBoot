package shah.uz;

import java.util.List;

public class Assisent {
    private String aname;
    private String asurname;
    private List<Long> hobby;

    public void setHobby(List<Long> hobby) {
        this.hobby = hobby;
    }

    public String getName() { return aname; }

    public void setaName(String aname) { this.aname = aname; }

    public String getSurname() { return asurname; }

    public void setaSurname(String asurname) { this.asurname = asurname; }

    @Override
    public String toString() {
        return "Assistant{" + "name='" + aname +
                '\'' + ", surname='" + asurname +
                '\'' + '}';
    }
}

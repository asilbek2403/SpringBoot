package shah.uz;

public class Professor {

    private String pname;
    private String psurname;

    public String getName() {
        return pname;}
    public void setpName(String pname) {
        this.pname = pname;}
    public String getSurname() {
        return psurname; }
    public void setpSurname(String psurname) {
        this.psurname = psurname; }

    @Override
    public String toString() {
        return "Professor{" + "name='" + pname +
                '\'' + ", surname='" + psurname +
                '\'' + '}';
    }
}

package shah.uz;

public class Lesson {
//    private String name; autowireda
    private Professor professor;
    private Assisent assisent;

    public Lesson() {
    }

//    public Lesson(String name, Professor professor, Assisent assisent) {
//        this.name = name;
//        this.professor = professor;
//        this.assisent = assisent;}

//Constructordan eng kop parametrlisin olib ishlaydi bean uchun

    public Lesson(Professor professor, Assisent assisent) {
        this.professor = professor;
        this.assisent = assisent;
    }

//    public Professor getProfessor() {
//        return professor;
//    }

//    public void setProfessor(Professor professor) {
//        this.professor = professor;
//    }

//    public Assisent getAssisent() {
//        return assisent;
    //}

//    public void setAssisent(Assisent assisent) {
//        this.assisent = assisent;
//    }

//    public void setName(String name) {
//        this.name = name;
//    } autowireda ishlamaydi

    @Override
    public String toString() {
        return "Lesson{  "+ " professor=" +
                professor +"'\n'"+ ", assisent=" + assisent + '}';
    }
}

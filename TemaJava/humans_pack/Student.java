package humans_pack;

public class Student extends People{

    private int an_studiu;

    public Student(String nume, String prenume, String facultate, int varsta, int an_studiu) {
        super(nume, prenume, facultate, varsta);
        this.an_studiu = an_studiu;
    }

    @Override
    public String toString(){
        return "[Sd."+this.nume+" "+this.prenume+", Anul "+this.an_studiu+", Fac."+this.getFacultate()+", Varsta "+this.varsta+"]";
    }

    @Override
    public String greeting(){
        return "Hello from student: "+this.nume+" "+this.prenume;
    }

    @Override
    public String doWork(){
        return "I am studying hard "+this.nume+" "+this.prenume;
    }
}

package humans_pack;

public class Profesor extends People{

    private String materie;

    public Profesor(String nume, String prenume, String facultate, int varsta, String materie) {
        super(nume, prenume, facultate, varsta);
        this.materie = materie;
    }

    @Override
    public String toString(){
        //[Prof. <Nume> <Prenume>, Fac. <Acronim>, Vârstă <Varsta>, Materie predată - <Materie>]
        return "[Prof."+this.nume+" "+this.prenume+", Fac."+this.getFacultate()+", Varsta "+this.varsta+", Materie predata - "+this.materie+"]";
    }

    @Override
    public String greeting(){
        return "Hello from professor: "+this.nume+" "+this.prenume;
    }

    @Override
    public String doWork(){
        return "I am working hard "+this.nume+" "+this.prenume;
    }
}

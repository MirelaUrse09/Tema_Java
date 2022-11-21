package humans_pack;

public class Main {
    public static void main(String[] args){
        Student student1= new Student("Urse","Mirela","ATM",22,4);
        Student student2= new Student("Iancu","Andrei","ASE",12,1);

        Profesor profesor1 = new Profesor("Madlena","Nen","ASE",45,"Management");

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(profesor1.toString());

        Human om = new Profesor("Badoi","Mugur","ATM",50,"Modelare Simulare");

        System.out.println(om.toString());


    }
}

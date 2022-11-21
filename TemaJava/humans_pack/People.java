package humans_pack;

public abstract class People implements Human,Comparable<People>{
    protected String nume;
    protected String prenume;
    protected String facultate;
    protected int varsta;

    public People(String nume, String prenume, String facultate, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.facultate = facultate;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getFacultate() {
        return facultate;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public int compareTo(People o) {
        if(this.varsta > o.varsta)
            return 1;
        else if(this.varsta< o.varsta)
            return -1;
        else
            return 0;
    }
}
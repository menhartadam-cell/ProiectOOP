public class Elev {
   // Cerinta: cosntructor cu 4 parametrii
    //Creeaza un elev cu toate datele
    private int id; //cerinta 2 , toate campurine private
    private String nume;
    private int varsta;
    private double medie;

    //getter si setter ppentru ID
    //validare : Id-ul trebuie sa fie pozitiv
    public int getId() { // da-mi ID-ul
        return id;
    }

    public void setId(int id) { //Setez ID-ul
        if (id > 0) {
            this.id = id;
        }
    }

    //Cerinta: getter si setter pentru nume
    //Validare:numele nu poate fi null si nu poate fi gol
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        if (nume != null && !nume.isEmpty()) {//if verifica daca numele exista si daca textul este gol
            this.nume = nume;
        }
    }

    //Cerinta: getter si setter pentru varsta
    //Validare: varsta sa fie intre 6-26
    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        if (varsta >= 6 && varsta <= 26) {
            this.varsta = varsta;
        }
    }

    // Cerinta: getter si setter pentru medie
// Validare: media trebuie sa fie intre 1 si 10
    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        if (medie >= 1 && medie <= 10) {
            this.medie = medie;
        }
    }
    //cerinta : constructor implicit
    //nu are tip de returnare(int , void), are acelasi nume cu clasa
    public Elev() {
    }

    // CERINTA: constructor cu 2 parametri
// Creeaza un elev folosind doar id-ul si numele
    public Elev(int id,String nume) {
         setId(id);
         setNume(nume);
    }
    public Elev (int id,String nume,int varsta,double medie) {
        setId(id);
        setNume(nume);
        setVarsta(varsta);
        setMedie(medie);
    }
    // CERINTA: metoda toString()
// Returneaza toate informatiile despre elev sub forma de text
    @Override //suprascriem metoda toString
    public String toString() {
        return "Elev{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ",varsta=" + varsta +
                ",medie=" + medie +
                '}';
    }

        // CERINTA: regula pentru promovare
// Returneaza true daca elevul are media cel putin 5
// Returneaza false daca media este mai mica de 5
    public boolean estePromovat() {
        return medie >= 5;
    }




}









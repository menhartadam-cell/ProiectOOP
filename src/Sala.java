import java.util.List;
import java.util.ArrayList;


public class Sala {
    //cerinta 3 : sala , campuri private
    private int id;
    private String denumire;
    private int capacitate;
    //Lista care va contine elevii din aceasta sala
    private List<Elev> elevi;

    // CERINTA: getter si setter pentru ID-ul salii
// Validare:ID-ul salii trebuie sa fie pozitiv
    public int getId() { //da-mi ID-ul acestei sali
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;//seteaza ID-ul salii daca este pozitiv
        }
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        if (denumire != null && !denumire.isEmpty()) {
            this.denumire = denumire;
        }
    }

    // CERINTA: getter si setter pentru capacitatea salii
    // Validare: capacitatea trebuie sa fie pozitiva
    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        if (capacitate > 0) {
            this.capacitate = capacitate;
        }
    }

    //getter si setter pentru lista de elevi
    public void setElevi(List<Elev> elevi) {
        this.elevi = elevi;
    }

    public List<Elev> getElevi() {
        return elevi;
    }
    //CERINTA:constructor implicit,fara parametri
//Cand cream o sala, cream automat si o lista goala de elevi
    public Sala() {
        elevi=new ArrayList<>();
    }
    //CERINTA: primul constructor cu parametri
//Creeaza o sala cu id, denumire si capacitate
    public Sala(int id,String denumire, int capacitate) {
        setId(id);
        setDenumire(denumire);
        setCapacitate(capacitate);
        // La inceput sala nu are elevi
        elevi = new ArrayList<>();
    }
    // CERINTA: al doilea constructor cu parametri
// Creeaza o sala si ii atribuie direct o lista de elevi
    public Sala(int id, String denumire, int capacitate, List<Elev> elevi) {
        setId(id);
        setDenumire(denumire);
        setCapacitate(capacitate);
        //Verificam daca lista exista si daca numarul elevilor nu depasaeste capaictate salii
        if (elevi != null && elevi.size() <= capacitate) {
            this.elevi = elevi;
        } else {
            this.elevi = new ArrayList<>();
        }
    }
    //CERINTA: metoda pentru adaugarea unui elev in sala
//Elevul este adaugat doar daca mai exista loc in sala
    public boolean adaugaElev(Elev elev) {
        if (elev != null && elevi.size() < capacitate) {
            elevi.add(elev);
            return true;//= levul a fost adaugat
        }
        return false;//elevul nu a fost adaugat
    }
    //CERINTA: metoda pentru stergerea unui elev din sala
//Cautam elevul dupa ID si il stergem daca il gasim
    public boolean stergeElev(int idElev) {
        // Parcurgem lista de elevi
        for (int i=0; i<elevi.size();i++) {
            // Verificam daca elevul de pe pozitia i are ID-ul cautat
            if (elevi.get(i).getId()==idElev) {
                // Stergem elevul de pe pozitia i
                elevi.remove(i);
                // true=elevul a fost gasit si sters
                return true;
            }
        }
        //false=nu am gasit niciun elev cu acest ID
        return false;
    }
    // CERINTA: cautarea unui elev dupa ID
//Daca gasim elevul atunci il returnam
//daca nu il gasim, returnam null
    public Elev cautaElev(int idElev) {
        //pentru fiecare elev din lista elevi
        for (Elev elev : elevi) {
            //Verificam daca ID-ul este cel cautat
            if(elev.getId()==idElev) {
                return elev;
            }
        }
        return null;//nu am gasit elevul
    }
    //verifica daca sala este plina
    public boolean estePlina() {
        return elevi.size()>=capacitate;
    }
    //returneaza numarul de locuri libere din sala
    public int getLocuriLibere() {
        return capacitate - elevi.size();
    }
    //Cerinta:metoda toString()
//returneaza informatiile despre sala sub forma de text
    @Override //folosim prorpa carianta toString
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", capacitate=" + capacitate +
                ", numarElevi=" + elevi.size() +
                ", elevi=" + elevi +
                '}';
    }

}











































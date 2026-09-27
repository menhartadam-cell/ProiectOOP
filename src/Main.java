import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Lista in care pastram toti elevii creati
        List<Elev> elevi = new ArrayList<>();
        //lista in care pastram toate salile create
        List<Sala> sali = new ArrayList<>();
        //variabila in care vom salva optiunea aleasa din meniu
        int optiune;

        //Meniul se repeta pana cand utilizatorul alege sa inchida programul
        do
//do while aici inseamna , fa ce este intre acolade si verifica daca trebuie sa repeti
        {
            System.out.println("\n===== MENIU =====");
            System.out.println("1.Adauga elev");
            System.out.println("2.Creeaza sala");
            System.out.println("3.Adauga elev intr-o sala");
            System.out.println("4.Afiseaza toti elevii");
            System.out.println("5.Afiseaza toate salile");
            System.out.println("6.Afiseaza elevii unei sali");
            System.out.println("7.Cauta elev dupa ID");
            System.out.println("8.Muta elev dintr-o sala in alta");
            System.out.println("9.Sterge elev");
            System.out.println("10.Sterge sala");
            System.out.println("11.Afiseaza elevii promovati");
            System.out.println("12.Afiseaza elevii nepromovati");
            System.out.println("13.Filtreaza elevii dupa medie");
            System.out.println("14.Filtreaza elevii dupa varsta");
            System.out.println("15.Cauta elev dupa nume");
            System.out.println("16.Afiseaza statistici");
            System.out.println("17.Sorteaza elevii");
            System.out.println("18.Inchide aplicatia");
            System.out.print("Alege o optiune: ");
            //citim optiunea introdusa de utilizator
            optiune = sc.nextInt();


            // Verificam ce optiune a ales utilizatorul
            switch (optiune) {
                //1 Adauga elevi
                case 1:
                    System.out.print("Introdu ID-ul elevului: ");
                    int idElev = sc.nextInt();
                    //verificam daca ID-ul exista deja
                    boolean idExista = false;
                    for (Elev elev : elevi) {
                        if (elev.getId() == idElev) {
                            idExista = true;
                            break;
                        }
                    }
                    if (idExista) {
                        System.out.println("Exista deja un elev cu acest ID!");
                        break;
                    }
                    System.out.print("Introdu numele elevului:");
                    sc.nextLine(); //curatam Enter-ul ramas dupa nextInt()
                    String nume = sc.nextLine();
                    System.out.print("Introdu varsta elevului:");
                    int varsta = sc.nextInt();
                    System.out.print("Introdu media elevului:");
                    double medie = sc.nextDouble();
                    //cream obiectul Elev
                    Elev elevNou = new Elev(idElev, nume, varsta, medie);
                    //il adaugam in lista tuturor elevilor
                    elevi.add(elevNou);
                    System.out.println("Elev adaugat cu succes!");
                    break;
                //2 Creaza sala
                case 2:
                    System.out.print("Introdu ID-ul salii:");
                    int idSala = sc.nextInt();
                    //verificam daca exista deja o sala cu acest ID
                    boolean salaExista = false;
                    for (Sala sala : sali) {
                        if (sala.getId() == idSala) {
                            salaExista = true;
                            break;
                        }
                    }
                    if (salaExista) {
                        System.out.println("Exista deja o sala cu acest ID!");
                        break;
                    }
                    System.out.print("Introdu denumirea salii:");
                    sc.nextLine();
                    String denumire = sc.nextLine();
                    System.out.print("Introdu capacitatea salii:");
                    int capacitate = sc.nextInt();
                    //cream sala
                    Sala salaNoua = new Sala(idSala, denumire, capacitate);
                    //adaugam sala in lista
                    sali.add(salaNoua);
                    System.out.println("Sala creata cu succes!");
                    break;
                // 3.Adauga un elev intr-o sala
                case 3:
                    System.out.print("Introdu ID-ul elevului:");
                    int idElevAdaugat = sc.nextInt();
                    //vom salva elevul daca il gasim
                    Elev elevGasit = null;
                    //cautam elevul in lista tuturor elevilor
                    for (Elev elev : elevi) {
                        if (elev.getId() == idElevAdaugat) {
                            elevGasit = elev;
                            break;
                        }
                    }
                    //daca elevGasit a ramas null, elevul nu exista
                    if (elevGasit == null) {
                        System.out.println("Elevul nu exista!");
                        break;
                    }
                    System.out.print("Introdu ID-ul salii:");
                    int idSalaAdaugare = sc.nextInt();
                    //aici vom salva sala daca o gasim
                    Sala salaGasita = null;
                    //cautam sala dupa ID
                    for (Sala sala : sali) {
                        if (sala.getId() == idSalaAdaugare) {
                            salaGasita = sala;
                            break;
                        }
                    }
                    //verificam daca sala exista
                    if (salaGasita == null) {
                        System.out.println("Sala nu exista!");
                        break;
                    }
                    //incercam sa adaugam elevul in sala
                    if (salaGasita.adaugaElev(elevGasit)) {
                        System.out.println("Elevul a fost adaugat in sala!");
                    } else {
                        System.out.println("Elevul nu a putut fi adaugat. Sala este plina.");
                    }
                    break;
                // 4.afiseaza toti elevii
                case 4:
                    //erificam daca lista de elevi este goala
                    if (elevi.isEmpty()) {
                        System.out.println("Nu exista elevi.");
                    } else {
                        //parcurgem lista si afisam fiecare elev
                        for (Elev elev : elevi) {
                            System.out.println(elev);
                        }
                    }
                    break;
                // 5.Afiseaza toate salile
                case 5:
                    //verificam daca lista de sali este goala
                    if (sali.isEmpty()) {
                        System.out.println("Nu exista sali.");
                    } else {
                        //parcurgem lista si afisam fiecare sala
                        for (Sala sala:sali) {
                            System.out.println(sala);
                        }
                    }
                    break;
                // 6. Afiseaza elevii unei sali
                case 6:
                    System.out.print("Introdu ID-ul salii: ");
                    int idSalaAfisare=sc.nextInt();
                    //Initial nu am gasit sala
                    Sala salaPentruAfisare=null;
                    //Cautam sala dupa ID
                    for (Sala sala : sali) {
                        if (sala.getId()==idSalaAfisare) {
                            salaPentruAfisare = sala;
                            break;
                        }
                    }
                    //Verificam daca sala exista
                    if (salaPentruAfisare==null) {
                        System.out.println("Sala nu exista.");
                    } else if (salaPentruAfisare.getElevi().isEmpty()) {
                        System.out.println("Sala nu are elevi.");
                    } else {
                        //afisam toti elevii din sala
                        for (Elev elev : salaPentruAfisare.getElevi()) {
                            System.out.println(elev);
                        }
                    }
                    break;
                // 7.Cauta elev dupa ID
                case 7:

                    System.out.print("Introdu ID-ul elevului cautat: ");
                    int idCautat = sc.nextInt();

                    //initial nu am gasit elevul
                    Elev elevCautat=null;
                    //cautam elevul in lista
                    for (Elev elev:elevi) {
                        if (elev.getId()==idCautat) {
                            elevCautat = elev;
                            break;
                        }
                    }
                    //verificam daca elevul a fost gasit
                    if (elevCautat != null) {
                        System.out.println("Elev gasit:");
                        System.out.println(elevCautat);
                    } else {
                        System.out.println("Elevul nu a fost gasit.");
                    }
                    break;
                // 8.Muta elev dintr-o sala in alta
                case 8:

                    System.out.print("Introdu ID-ul elevului: ");
                    int idElevMutat=sc.nextInt();

                    System.out.print("Introdu ID-ul salii din care pleaca: ");
                    int idSalaVeche=sc.nextInt();

                    System.out.print("Introdu ID-ul salii in care se muta: ");
                    int idSalaNoua=sc.nextInt();

                    //Initial nu am gasit salile
                    Sala salaVeche=null;
                    Sala salaNouaDestinatie=null;

                    // Cautam cele doua sali
                    for (Sala sala:sali) {

                        if (sala.getId()==idSalaVeche) {
                            salaVeche=sala;
                        }

                        if (sala.getId()==idSalaNoua) {
                            salaNouaDestinatie=sala;
                        }
                    }

                    //Verificam daca ambele sali exista
                    if (salaVeche==null||salaNouaDestinatie==null) {
                        System.out.println("Una dintre sali nu exista!");
                        break;
                    }
                    //Cautam elevul in sala veche
                    Elev elevDeMutat= salaVeche.cautaElev(idElevMutat);
                    if (elevDeMutat==null) {
                        System.out.println("Elevul nu exista in sala respectiva!");
                        break;
                    }
                    //Verificam daca sala noua este plina
                    if (salaNouaDestinatie.estePlina()) {
                        System.out.println("Sala noua este plina!");
                        break;
                    }
                    //Stergem elevul din sala veche
                    salaVeche.stergeElev(idElevMutat);
                    //Il adaugam in sala noua
                    salaNouaDestinatie.adaugaElev(elevDeMutat);
                    System.out.println("Elevul a fost mutat cu succes!");
                    break;
                // 9. Sterge elev
                case 9:
                    System.out.print("Introdu ID-ul elevului de sters: ");
                    int idElevSters = sc.nextInt();
                    //Initial nu am gasit elevul
                    Elev elevDeSters = null;
                    // Cautam elevul in lista tuturor elevilor
                    for (Elev elev: elevi) {
                        if (elev.getId()==idElevSters) {
                            elevDeSters=elev;
                            break;
                        }
                    }
                    //verificam daca elevul exista
                    if (elevDeSters==null) {
                        System.out.println("Elevul nu exista!");
                        break;
                    }
                    //Stergem elevul din orice sala in care se afla
                    for (Sala sala:sali) {
                        sala.stergeElev(idElevSters);
                    }
                    //Stergem elevul din lista tuturor elevilor
                    elevi.remove(elevDeSters);
                    System.out.println("Elevul a fost sters!");
                    break;
                // 10.Sterge sala
                case 10:
                    System.out.print("Introdu ID-ul salii de sters: ");
                    int idSalaStearsa = sc.nextInt();
                    //Initial nu am gasit sala
                    Sala salaDeSters=null;
                    //Cautam sala dupa ID
                    for (Sala sala : sali) {
                        if (sala.getId()==idSalaStearsa) {
                            salaDeSters=sala;
                            break;
                        }
                    }
                    //Verificam daca sala exista
                    if (salaDeSters==null) {
                        System.out.println("Sala nu exista!");
                    } else {
                        sali.remove(salaDeSters);
                        System.out.println("Sala a fost stearsa!");
                    }
                    break;
                // 11. Afiseaza elevii promovati
                case 11:
                    System.out.println("Elevi promovati:");
                    boolean existaPromovati = false;
                    //Parcurgem toti elevii
                    for (Elev elev : elevi) {
                        if (elev.estePromovat()) {
                            System.out.println(elev);
                            existaPromovati=true;
                        }
                    }
                    //Verificam daca nu am gasit niciun elev promovat
                    if (!existaPromovati) {
                        System.out.println("Nu exista elevi promovati.");
                    }
                    break;
                // 12.Afiseaza elevii nepromovati
                case 12:
                    System.out.println("Elevi nepromovati:");
                    boolean existaNepromovati = false;
                    //parcurgem toti elevii
                    for (Elev elev : elevi) {
                        if (!elev.estePromovat()) {
                            System.out.println(elev);
                            existaNepromovati=true;
                        }
                    }
                    //verificam daca nu am gasit niciun elev nepromovat
                    if (!existaNepromovati) {
                        System.out.println("Nu exista elevi nepromovati.");
                    }
                    break;
                // 13 Filtreaza elevii dupa medie
                case 13:
                    System.out.print("Introdu media minima:");
                    double medieMinima = sc.nextDouble();
                    System.out.print("Introdu media maxima:");
                    double medieMaxima = sc.nextDouble();
                    boolean elevGasitDupaMedie = false;
                    // Cautam elevii care au media in intervalul ales
                    for(Elev elev:elevi) {
                        if (elev.getMedie()>=medieMinima && elev.getMedie() <= medieMaxima) {
                            System.out.println(elev);
                            elevGasitDupaMedie=true;
                        }
                    }
                    if(!elevGasitDupaMedie) {
                        System.out.println("Nu exista elevi in acest interval.");
                    }
                    break;
                //14.Filtreaza elevii dupa varsta
                case 14:
                    System.out.print("Introdu varsta cautata: ");
                    int varstaCautata=sc.nextInt();
                    boolean elevGasitDupaVarsta = false;
                    //cautam elevii care au varsta introdusa
                    for (Elev elev: elevi) {
                        if (elev.getVarsta()==varstaCautata) {
                            System.out.println(elev);
                            elevGasitDupaVarsta=true;
                        }
                    }
                    if (!elevGasitDupaVarsta) {
                        System.out.println("Nu exista elevi cu aceasta varsta.");
                    }
                    break;
                // 15Cauta elev dupa nume
                case 15:
                    System.out.print("Introdu numele cautat: ");
                    sc.nextLine(); //curatam Enter-ul ramas
                    String numeCautat=sc.nextLine();
                    boolean elevGasitDupaNume=false;
                    //cautam elevul dupa nume
                    for (Elev elev:elevi) {
                        if (elev.getNume().equalsIgnoreCase(numeCautat)) {
                            System.out.println(elev);
                            elevGasitDupaNume=true;
                        }
                    }
                    if (!elevGasitDupaNume) {
                        System.out.println("Nu exista elev cu acest nume.");
                    }
                    break;
                // 16.afiseaza statistici
                case 16:
                    if (elevi.isEmpty()) {
                        System.out.println("Nu exista elevi pentru statistici.");
                    } else {
                        double sumaMediilor=0;
                        //adunam mediile tuturor elevilor
                        for (Elev elev : elevi) {
                            sumaMediilor=sumaMediilor+elev.getMedie();
                        }
                        //calculam media generala
                        double mediaGenerala = sumaMediilor / elevi.size();
                        System.out.println("Numar total de elevi: "+elevi.size());
                        System.out.println("Media generala: "+mediaGenerala);
                    }
                    break;
                // 17orteaza elevii dupa medie
                case 17:
                    //comparam mediile a doi elevi pentru sortare
                    elevi.sort((e1, e2) -> Double.compare(e1.getMedie(), e2.getMedie()));
                    System.out.println("Elevii au fost sortati dupa medie.");
                    //afisam elevii dupa sortare
                    for (Elev elev:elevi) {
                        System.out.println(elev);
                    }
                    break;
                // 18inchide aplicatia
                case 18:
                    System.out.println("Aplicatia se inchide.");
                    break;
//orice alta optiune
                default:
                    System.out.println("Optiune invalida!");
                    break;
            }
        } while (optiune != 18);
        sc.close(); //inchidem Scanner-ul
    }
}





























































































































































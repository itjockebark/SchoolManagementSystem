package com.company;

import static com.company.Utilities.*;
import static com.company.UserInputManagement.intScanner;

public class UI {

    public static void displayHeader() {
        System.out.println("""
                ____________________________________________
                          Utveckling mot databaser           
                           
                           SchoolManagementSystem           
                
                              Joakim Barkfjärd
                ____________________________________________""");

    }

    public static int mainMenu() {
        System.out.print("""
                ____________________________________________
                                 HUVUDMENY                
                ____________________________________________
                1. Lägg till och koppla
                2. Ta bort och koppla ifrån
                3. Uppdatera
                4. Sök
                5. Skriv ut
                6. Sortera
                7. Statistik
                
                0. Avsluta
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int addAndConnectManagementMenu() {
        System.out.print("""
                ____________________________________________
                            Lägg till och koppla                                                           
                ____________________________________________
                1. Lägg till 
                2. Koppla 
                3. Lägg till och koppla 
                4. Lägg till och koppla falska entiteter
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int addMenu() {
        System.out.print("""
                ____________________________________________
                                 Lägg till                                                   
                ____________________________________________
                1. Lägg till lärare
                2. Lägg till student
                3. Lägg till utbildning
                4. Lägg till kurs

                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int connectMenu() {
        System.out.print("""
                ____________________________________________
                                   Koppla                                                                                                            
                ____________________________________________
                1. Koppla lärare till utbildning
                2. Koppla student till utbildning
                3. Koppla kurs till utbildning
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int addAndConnectMenu() {
        System.out.print("""
                ____________________________________________
                            Lägg till och koppla                                                              
                ____________________________________________
                1. Lägg till ny lärare till existerande
                utbildning
                2. Lägg till ny student till existerande
                utbildning
                3. Lägg till ny kurs till existerande 
                utbildning
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }


    public static int removeAndDisconnectMenu() {
        System.out.print("""
                ____________________________________________
                          Ta bort och koppla ifrån                                                                                        
                ____________________________________________
                1. Ta bort
                2. Koppla ifrån
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int removeMenu() {
        System.out.print("""
                ____________________________________________
                                  Ta bort                                                                                                          
                ____________________________________________
                1. Ta bort med ID
                2. Ta bort med namn
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int removeByIdMenu() {
        System.out.print("""
                ____________________________________________
                               Ta bort med ID                                                                                                                        
                ____________________________________________
                1. Ta bort lärare med ID
                2. Ta bort student med ID
                3. Ta bort utbidlning med ID
                4. Ta bort kurs med ID
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int removeByNameMenu() {
        System.out.print("""
                ____________________________________________
                              Ta bort med namn                                                                                                                        
                ____________________________________________
                1. Ta bort lärare med namn
                2. Ta bort student med namn 
                3. Ta bort utbidlning med namn
                4. Ta bort kurs med namn
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int disconnectMenu() {
        System.out.print("""
                ____________________________________________
                                Koppla ifrån                                                                                                                         
                ____________________________________________
                1. Koppla ifrån lärare ifrån utbidlning
                2. Koppla ifrån student ifrån utbildning
                3. Koppla ifrån kurs ifrån utbildning
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int updateMenu() {
        System.out.print("""
                ____________________________________________
                                 Uppdatera                                                                                                                                       
                ____________________________________________
                1. Uppdatera namn på lärare
                2. Uppdatera födelsedatum på lärare
                3. Uppdatera namn på student
                4. Uppdatera födelsedatum på student
                5. Uppdatera namn på utbildning
                6. Uppdatera startdatum på utbildning
                7. Uppdatera namn på kurs
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int searchMenu() {
        System.out.print("""
                ____________________________________________
                                    Sök                                                                                                          
                ____________________________________________
                1. Sök med ID
                2. Sök med namn
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int searchByIdMenu() {
        System.out.print("""
                ____________________________________________
                                 Sök med ID                                                                                                                                                         
                ____________________________________________
                1. Sök efter lärare
                2. Sök efter student
                3. Sök efter utbildning
                4. Sök efter kurs
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int searchByNameMenu() {
        System.out.print("""
                ____________________________________________
                                Sök med namn                                                                                                                         
                ____________________________________________
                1. Sök efter lärare
                2. Sök efter student
                3. Sök efter utbildning
                4. Sök efter kurs
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int printMenu() {
        System.out.print("""
                ____________________________________________
                                  Skriv ut                                                                                                                                                   
                ____________________________________________
                1. Skriv ut alla lärare
                2. Skriv ut alla studenter
                3. Skriv ut alla utbildningar
                4. Skriv ut alla kurser
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int sortMenu() {
        System.out.print("""
                ____________________________________________
                                  Sortera                                                                                                                                                                                    
                ____________________________________________
                1. Sortera stigande
                2. Sortera fallande
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int sortAscendingMenu() {
        System.out.print("""
                ____________________________________________
                              Sortera stigande                                                                                                                                                                                              
                ____________________________________________
                1. Sortera lärare med namn
                2. Sortera student med födelsedatum
                3. Sortera utbildning med utbildnigns-ID
                4. Sortera utbildning med med namn
                5. Sortera kurs med namn
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int sortDescendingMenu() {
        System.out.print("""
                ____________________________________________
                              Sortera fallande                                                                                                                                                                                              
                ____________________________________________
                1. Sortera lärare med namn
                2. Sortera lärare med födelsedatum
                3. Sortera student med ID
                4. Sortera utbildning med utbildnings-ID
                5. Sortera kurs med namn
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int statisticsMenu() {
        System.out.print("""
                ____________________________________________
                                 Statistik                                                                                                                                                                   
                ____________________________________________
                1. Statistik på lärare
                2. Statistik på studenter
                3. Statistik på utbildningar
                4. Statistik på kurser
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int statisticsTeacherMenu() {
        System.out.print("""
                ____________________________________________
                              Statistik lärare                                                                                                                                                                                 
                ____________________________________________
                1. Totalt antal 
                2. Lägst ålder 
                3. Högst ålder 
                4. Genomsnittlig ålder
                5. Antalet som är äldre än 40
                6. Antalet som är yngre än 40 eller är 40 år gamla
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int statisticsStudentMenu() {
        System.out.print("""
                ____________________________________________
                             Statistik studenter                                                                                                                                                                               
                ____________________________________________
                1. Totalt antal 
                2. Lägst ålder 
                3. Högst ålder 
                4. Genomsnittlig ålder
                5. Antalet som är äldre än 30
                6. Antalet som är yngre än 30 eller är 30 år gamla
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }
    public static int statisticsEducationMenu() {
        System.out.print("""
                ____________________________________________
                           Statistik utbildningar                                                                                                                                                                                          
                ____________________________________________
                1. Totalt antal 
                2. Varaktighet längre än 12 månader
                3. Varaktighet kortare än 12 månader
                4. Antalet med startdatum efter 2020-07-14
                5. Antalet med startdatum innan 2020-07-14
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }

    public static int statisticsCourseMenu() {
        System.out.print("""
                ____________________________________________
                              Statistik kurser                                                                                                                                                                                            
                ____________________________________________
                1. Totalt antal 
                
                0. Huvudmeny
                ____________________________________________
                Var god välj:""");
        return userInputInt = intScanner();
    }
}

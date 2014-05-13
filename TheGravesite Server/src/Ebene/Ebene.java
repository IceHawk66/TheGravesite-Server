package Ebene;

public class Ebene {
    
    public static Boolean[][] Map(int hoehe, int breite) {
        Boolean[][] map = new Boolean[hoehe][breite];
        int zufall;
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = false;
            }
        }

        int endhoeheoberkante = (int)(Math.random() * 10);
        int starthoeheoberkante = endhoeheoberkante;
        int startpunktoberkante = (int)(Math.random() * 10);
        int endpunktoberkante = breite - (int)(Math.random() * 10) - 1;
        for (int i = startpunktoberkante; i < endpunktoberkante; i++){
            zufall = (int)(Math.random() * 9);
            if ((i < startpunktoberkante + 3) || (i > (endpunktoberkante - 3)))
                map[endhoeheoberkante][i] = true;
            else if (zufall == 0 || zufall == 1 || zufall == 2)
                map[endhoeheoberkante][i] = true;
            else if (zufall == 3 || zufall == 4){
                map[endhoeheoberkante][i] = true;
                if (endhoeheoberkante > 0){
                    map[--endhoeheoberkante][i] = true;
                    map[endhoeheoberkante][++i] = true;
                }
            }
            else if (zufall == 5){
                map[endhoeheoberkante][i] = true;
                if (endhoeheoberkante > 1){
                    map[--endhoeheoberkante][i] = true;
                    map[--endhoeheoberkante][i] = true;
                    map[endhoeheoberkante][++i] = true;
                }
            }
            else if (zufall == 6 || zufall == 7){
                map[endhoeheoberkante][i] = true;
                if (endhoeheoberkante < hoehe - 1){
                    map[++endhoeheoberkante][i] = true;
                    map[endhoeheoberkante][++i] = true;
                }
            }
            else if (zufall == 8){
                map[endhoeheoberkante][i] = true;
                if (endhoeheoberkante < hoehe - 2){
                    map[++endhoeheoberkante][i] = true;
                    map[++endhoeheoberkante][i] = true;
                    map[endhoeheoberkante][++i] = true;
                }
            }
        }
        
        
        
        
        
        
        
        
        int endbreitelinkekante = startpunktoberkante;
        int startbreitelinkekante = endbreitelinkekante;
        int startpunktlinkekante = starthoeheoberkante;
        int endpunktlinkekante = hoehe - (int)(Math.random() * 10) - 1;
        for (int i = startpunktlinkekante; i < endpunktlinkekante; i++){
            zufall = (int)(Math.random() * 9);
            if ((i < startpunktlinkekante + 3) || (i > (endpunktlinkekante - 3)))
                map[i][endbreitelinkekante] = true;
            else if (zufall == 0 || zufall == 1 || zufall == 2)
                map[i][endbreitelinkekante] = true;
            else if (zufall == 3 || zufall == 4){
                map[i][endbreitelinkekante] = true;
                if (endbreitelinkekante > 0){
                    map[i][--endbreitelinkekante] = true;
                    map[++i][endbreitelinkekante] = true;
                }
            }
            else if (zufall == 5){
                map[i][endbreitelinkekante] = true;
                if (endbreitelinkekante > 1){
                    map[i][--endbreitelinkekante] = true;
                    map[i][--endbreitelinkekante] = true;
                    map[++i][endbreitelinkekante] = true;
                }
            }
            else if (zufall == 6 || zufall == 7){
                map[i][endbreitelinkekante] = true;
                if (endbreitelinkekante < breite - 1){
                    map[i][++endbreitelinkekante] = true;
                    map[++i][endbreitelinkekante] = true;
                }
            }
            else if (zufall == 8){
                map[i][endbreitelinkekante] = true;
                if (endbreitelinkekante < breite - 2){
                    map[i][++endbreitelinkekante] = true;
                    map[i][++endbreitelinkekante] = true;
                    map[++i][endbreitelinkekante] = true;
                }
            }
        }
        
        
        
        
        
        
        
        int endbreiterechtekante = endpunktoberkante;
        int startbreiterechtekante = endbreiterechtekante;
        int startpunktrechtekante = endhoeheoberkante;
        int endpunktrechtekante = hoehe - (int)(Math.random() * 10) - 1;
        for (int i = startpunktrechtekante; i < endpunktrechtekante; i++){
            zufall = (int)(Math.random() * 9);
            if ((i < startpunktrechtekante + 3) || (i > (endpunktrechtekante - 3)))
                map[i][endbreiterechtekante] = true;
            else if (zufall == 0 || zufall == 1 || zufall == 2)
                map[i][endbreiterechtekante] = true;
            else if (zufall == 3 || zufall == 4){
                map[i][endbreiterechtekante] = true;
                if (endbreiterechtekante < breite - 1){
                    map[i][++endbreiterechtekante] = true;
                    map[++i][endbreiterechtekante] = true;
                }
            }
            else if (zufall == 5){
                map[i][endbreiterechtekante] = true;
                if (endbreiterechtekante < breite - 2){
                    map[i][++endbreiterechtekante] = true;
                    map[i][++endbreiterechtekante] = true;
                    map[++i][endbreiterechtekante] = true;
                }
            }
            else if (zufall == 6 || zufall == 7){
                map[i][endbreiterechtekante] = true;
                if (endbreiterechtekante > 0){
                    map[i][--endbreiterechtekante] = true;
                    map[++i][endbreiterechtekante] = true;
                }
            }
            else if (zufall == 8){
                map[i][endbreiterechtekante] = true;
                if (endbreiterechtekante > 1){
                    map[i][--endbreiterechtekante] = true;
                    map[i][--endbreiterechtekante] = true;
                    map[++i][endbreiterechtekante] = true;
                }
            }
        }
        
        
        
        
        
        
        
        int endhoeheunterkante = endpunktlinkekante;
        int zielhoeheunterkante = endpunktrechtekante;
        int startpunktunterkante = endbreitelinkekante;
        int endpunktunterkante = endbreiterechtekante;
        for (int i = startpunktunterkante; i < endpunktunterkante; i++){
            zufall = (int)(Math.random() * 9);
            
            
            
            
            if ((i < startpunktunterkante + 3) || (i > (endpunktunterkante - 3)))
                map[endhoeheunterkante][i] = true;
            else if (zufall == 0 || zufall == 1 || zufall == 2)
                map[endhoeheunterkante][i] = true;
            else if (zufall == 3 || zufall == 4){
                map[endhoeheunterkante][i] = true;
                if (endhoeheunterkante < hoehe - 1){
                    map[++endhoeheunterkante][i] = true;
                    map[endhoeheunterkante][++i] = true;
                }
            }
            else if (zufall == 5){
                map[endhoeheunterkante][i] = true;
                if (endhoeheunterkante < hoehe - 2){
                    map[++endhoeheunterkante][i] = true;
                    map[++endhoeheunterkante][i] = true;
                    map[endhoeheunterkante][++i] = true;
                }
            }
            else if (zufall == 6 || zufall == 7){
                map[endhoeheunterkante][i] = true;
                if (endhoeheunterkante > 0){
                    map[--endhoeheunterkante][i] = true;
                    map[endhoeheunterkante][++i] = true;
                }
            }
            else if (zufall == 8){
                map[endhoeheunterkante][i] = true;
                if (endhoeheunterkante > 1){
                    map[--endhoeheunterkante][i] = true;
                    map[--endhoeheunterkante][i] = true;
                    map[endhoeheunterkante][++i] = true;
                }
            }
        }
        
        
        
        
        
        
        
        
        
        return map;
    }
    
    public static void Darstellen(Boolean[][] map) {
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] == false)
                    System.out.print("'");
                if (map[i][j] == true)
                    System.out.print("#");
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

}
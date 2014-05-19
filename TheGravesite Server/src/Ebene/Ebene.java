package Ebene;

public class Ebene {
/*
	public static void main(String[] args) {
        int[][] map = Map(40, 80);
        Darstellen(map);
    }
    
	*/
	int[][] map;
	
	public Ebene(int hoehe, int breite){
		erstelleEbene(hoehe, breite);
	}
	
    public void erstelleEbene(int hoehe, int breite) {
        map = new int[hoehe][breite];
        int zufall;
        for (int i = 0; i < map.length; i++){												//die gesamte Karte wird anfangs als Wegpunkte definiert
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = 2;
            }
        }

        int endhoeheoberkante = (int)(Math.random() * 10);									//aktuelle Hˆhe der Oberkante (ver‰ndert sich und gibt am Ende die Hˆhe des letzten Mauerst¸cks an)
        int starthoeheoberkante = endhoeheoberkante;										//die Hˆhe des ersten Mauerst¸cks wird gespeichert
        int startpunktoberkante = (int)(Math.random() * 10);								//der Punkt des ersten Mauerst¸cks wird berechnet
        int endpunktoberkante = breite - (int)(Math.random() * 10) - 1;						//der Punkt des letzten Mauerst¸cks wird berechnet
        
        for (int i = 0; i <= starthoeheoberkante; i++){										//die obere linke Ecke wird als leer definiert
        	for (int j = 0; j <= startpunktoberkante; j++){
        		map[i][j] = 0;
        	}
        }
        
        for (int i = startpunktoberkante; i < endpunktoberkante; i++){						//der Bereich zwischen dem ersten und letzten Mauerst¸ck der oberen Kante wird durchlaufen
            zufall = (int)(Math.random() * 9);
            if ((i < startpunktoberkante + 3) || (i > (endpunktoberkante - 3))){			//die ersten und letzten 3 Mauerst¸cke sollen eine gerade Mauer ergeben
                map[endhoeheoberkante][i] = 1;
                for(int j = 0; j < endhoeheoberkante; j++)
                	map[j][i] = 0;															//der Bereich ¸ber der Mauer wird als leer definiert (wird im Folgenden h‰ufiger verwendet)
            }
            else if (zufall <= 2){															//mit einer Wahrscheinlichkeit von 3/9 wird ein gerades Mauerst¸ck erstellt
                map[endhoeheoberkante][i] = 1;
                for(int j = 0; j < endhoeheoberkante; j++)
                	map[j][i] = 0;
            }
            else if (zufall <= 4){															//mit einer Wahrscheinlichkeit von 2/9 wird ein Mauerst¸ck erstellt, das einen Schritt nach oben macht
                map[endhoeheoberkante][i] = 1;
                for(int j = 0; j < endhoeheoberkante; j++)
                	map[j][i] = 0;
                if (endhoeheoberkante > 0){
                    map[--endhoeheoberkante][i] = 1;
                    map[endhoeheoberkante][++i] = 1;
                    for(int j = 0; j < endhoeheoberkante; j++)
                    	map[j][i] = 0;
                }
            }
            else if (zufall == 5){															//mit einer Wahrscheinlichkeit von 1/9 wird ein Mauerst¸ck erstellt, das zwei Schritte nach oben macht
                map[endhoeheoberkante][i] = 1;
                for(int j = 0; j < endhoeheoberkante; j++)
                	map[j][i] = 0;
                if (endhoeheoberkante > 1){
                    map[--endhoeheoberkante][i] = 1;
                    map[--endhoeheoberkante][i] = 1;
                    map[endhoeheoberkante][++i] = 1;
                    for(int j = 0; j < endhoeheoberkante; j++)
                    	map[j][i] = 0;
                }
            }
            else if (zufall <= 7){															//mit einer Wahrscheinlichkeit von 2/9 wird ein Mauerst¸ck erstellt, das einen Schritt nach unten macht
                map[endhoeheoberkante][i] = 1;
                for(int j = 0; j < endhoeheoberkante; j++)
                	map[j][i] = 0;
                if (endhoeheoberkante < hoehe - 1){
                    map[++endhoeheoberkante][i] = 1;
                    map[endhoeheoberkante][++i] = 1;
                    for(int j = 0; j < endhoeheoberkante; j++)
                    	map[j][i] = 0;
                }
            }
            else if (zufall == 8){															//mit einer Wahrscheinlichkeit von 1/9 wird ein Mauerst¸ck erstellt, das zwei Schritte nach unten macht
                map[endhoeheoberkante][i] = 1;
                for(int j = 0; j < endhoeheoberkante; j++)
                	map[j][i] = 0;
                if (endhoeheoberkante < hoehe - 2){
                    map[++endhoeheoberkante][i] = 1;
                    map[++endhoeheoberkante][i] = 1;
                    map[endhoeheoberkante][++i] = 1;
                    for(int j = 0; j < endhoeheoberkante; j++)
                    	map[j][i] = 0;
                }
            }
        }
        
        
        
        int endbreitelinkekante = startpunktoberkante;										//aktuelle Breite der linken Kante (ver‰ndert sich und gibt am Ende die Breite des letzten Mauerst¸cks an)(entspricht dem Punkt des ersten Mauerst¸cks der Oberkante)
        int startbreitelinkekante = endbreitelinkekante;									//die Breite des ersten Mauerst¸cks wird gespeichert
        int startpunktlinkekante = starthoeheoberkante;										//der Punkt des ersten Mauerst¸cks wird gespeichert (entspricht der Hˆhe des ersten Mauerst¸cks der Oberkante)
        int endpunktlinkekante = hoehe - (int)(Math.random() * 10) - 1;						//der Punkt des letzten Mauerst¸cks wird berechnet
        
        for (int i = startpunktlinkekante; i < endpunktlinkekante; i++){					//der Bereich zwischen dem ersten und letzten Mauerst¸ck der linken Kante wird durchlaufen
            zufall = (int)(Math.random() * 9);
            if ((i < startpunktlinkekante + 3) || (i > (endpunktlinkekante - 3))){			//die ersten und letzten 3 Mauerst¸cke sollen eine gerade Mauer ergeben
                map[i][endbreitelinkekante] = 1;
                for(int j = 0; j < endbreitelinkekante; j++)
                	map[i][j] = 0;															//der Bereich ¸ber der Mauer wird als leer definiert (wird im Folgenden h‰ufiger verwendet)
            }
            else if (zufall <= 2){															//mit einer Wahrscheinlichkeit von 3/9 wird ein gerades Mauerst¸ck erstellt
                map[i][endbreitelinkekante] = 1;
                for(int j = 0; j < endbreitelinkekante; j++)
                	map[i][j] = 0;
            }
            else if (zufall <= 4){															//mit einer Wahrscheinlichkeit von 2/9 wird ein Mauerst¸ck erstellt, das einen Schritt nach links macht
                map[i][endbreitelinkekante] = 1;
                for(int j = 0; j < endbreitelinkekante; j++)
                	map[i][j] = 0;
                if (endbreitelinkekante > 0){
                    map[i][--endbreitelinkekante] = 1;
                    map[++i][endbreitelinkekante] = 1;
                    for(int j = 0; j < endbreitelinkekante; j++)
                    	map[i][j] = 0;
                }
            }
            else if (zufall == 5){															//mit einer Wahrscheinlichkeit von 1/9 wird ein Mauerst¸ck erstellt, das zwei Schritte nach links macht
                map[i][endbreitelinkekante] = 1;
                for(int j = 0; j < endbreitelinkekante; j++)
                	map[i][j] = 0;
                if (endbreitelinkekante > 1){
                    map[i][--endbreitelinkekante] = 1;
                    map[i][--endbreitelinkekante] = 1;
                    map[++i][endbreitelinkekante] = 1;
                    for(int j = 0; j < endbreitelinkekante; j++)
                    	map[i][j] = 0;
                }
            }
            else if (zufall <= 7){															//mit einer Wahrscheinlichkeit von 2/9 wird ein Mauerst¸ck erstellt, das einen Schritt nach rechts macht
                map[i][endbreitelinkekante] = 1;
                for(int j = 0; j < endbreitelinkekante; j++)
                	map[i][j] = 0;
                if (endbreitelinkekante < breite - 1){
                    map[i][++endbreitelinkekante] = 1;
                    map[++i][endbreitelinkekante] = 1;
                    for(int j = 0; j < endbreitelinkekante; j++)
                    	map[i][j] = 0;
                }
            }
            else if (zufall == 8){															//mit einer Wahrscheinlichkeit von 1/9 wird ein Mauerst¸ck erstellt, das zwei Schritte nach rechts macht
                map[i][endbreitelinkekante] = 1;
                for(int j = 0; j < endbreitelinkekante; j++)
                	map[i][j] = 0;
                if (endbreitelinkekante < breite - 2){
                    map[i][++endbreitelinkekante] = 1;
                    map[i][++endbreitelinkekante] = 1;
                    map[++i][endbreitelinkekante] = 1;
                    for(int j = 0; j < endbreitelinkekante; j++)
                    	map[i][j] = 0;
                }
            }
        }      
        
        
        
        int endbreiterechtekante = endpunktoberkante;										//aktuelle Breite der rechten Kante (ver‰ndert sich und gibt am Ende die Breite des letzten Mauerst¸cks an)(entspricht dem Punkt des letzen Mauerst¸cks der Oberkante)
        int startbreiterechtekante = endbreiterechtekante;									//die Breite des ersten Mauerst¸cks wird gespeichert
        int startpunktrechtekante = endhoeheoberkante;										//der Punkt des ersten Mauerst¸cks wird gespeichert (entspricht der Hˆhe des letzen Mauerst¸cks der Oberkante)
        int endpunktrechtekante = hoehe - (int)(Math.random() * 10) - 1;					//der Punkt des letzten Mauerst¸cks wird berechnet
        
        for (int i = 0; i <= startpunktrechtekante; i++){									//die obere rechte Ecke wird als leer definiert
        	for (int j = map[i].length - 1; j >= startbreiterechtekante; j--){
        		map[i][j] = 0;
        	}
        }
        
        for (int i = startpunktrechtekante; i < endpunktrechtekante; i++){					//der Bereich zwischen dem ersten und letzten Mauerst¸ck der rechten Kante wird durchlaufen
            zufall = (int)(Math.random() * 9);
            if ((i < startpunktrechtekante + 3) || (i > (endpunktrechtekante - 3))){		//die ersten und letzten 3 Mauerst¸cke sollen eine gerade Mauer ergeben
                map[i][endbreiterechtekante] = 1;
                for(int j = map[i].length - 1; j > endbreiterechtekante; j--)
                	map[i][j] = 0;															//der Bereich ¸ber der Mauer wird als leer definiert (wird im Folgenden h‰ufiger verwendet)
            }
            else if (zufall <= 2){															//mit einer Wahrscheinlichkeit von 3/9 wird ein gerades Mauerst¸ck erstellt
                map[i][endbreiterechtekante] = 1;
                for(int j = map[i].length - 1; j > endbreiterechtekante; j--)
                	map[i][j] = 0;
            }
            else if (zufall <= 4){															//mit einer Wahrscheinlichkeit von 2/9 wird ein Mauerst¸ck erstellt, das einen Schritt nach rechts macht
                map[i][endbreiterechtekante] = 1;
                for(int j = map[i].length - 1; j > endbreiterechtekante; j--)
                	map[i][j] = 0;
                if (endbreiterechtekante < breite - 1){
                    map[i][++endbreiterechtekante] = 1;
                    map[++i][endbreiterechtekante] = 1;
                    for(int j = map[i].length - 1; j > endbreiterechtekante; j--)
                    	map[i][j] = 0;
                }
            }
            else if (zufall == 5){															//mit einer Wahrscheinlichkeit von 1/9 wird ein Mauerst¸ck erstellt, das zwei Schritte nach rechts macht
                map[i][endbreiterechtekante] = 1;
                for(int j = map[i].length - 1; j > endbreiterechtekante; j--)
                	map[i][j] = 0;
                if (endbreiterechtekante < breite - 2){
                    map[i][++endbreiterechtekante] = 1;
                    map[i][++endbreiterechtekante] = 1;
                    map[++i][endbreiterechtekante] = 1;
                    for(int j = map[i].length - 1; j > endbreiterechtekante; j--)
                    	map[i][j] = 0;
                }
            }
            else if (zufall <= 7){															//mit einer Wahrscheinlichkeit von 2/9 wird ein Mauerst¸ck erstellt, das einen Schritt nach links macht
                map[i][endbreiterechtekante] = 1;
                for(int j = map[i].length - 1; j > endbreiterechtekante; j--)
                	map[i][j] = 0;
                if (endbreiterechtekante > 0){
                    map[i][--endbreiterechtekante] = 1;
                    map[++i][endbreiterechtekante] = 1;
                    for(int j = map[i].length - 1; j > endbreiterechtekante; j--)
                    	map[i][j] = 0;
                }
            }
            else if (zufall == 8){															//mit einer Wahrscheinlichkeit von 1/9 wird ein Mauerst¸ck erstellt, das zwei Schritte nach links macht
                map[i][endbreiterechtekante] = 1;
                for(int j = map[i].length - 1; j > endbreiterechtekante; j--)
                	map[i][j] = 0;
                if (endbreiterechtekante > 1){
                    map[i][--endbreiterechtekante] = 1;
                    map[i][--endbreiterechtekante] = 1;
                    map[++i][endbreiterechtekante] = 1;
                    for(int j = map[i].length - 1; j > endbreiterechtekante; j--)
                    	map[i][j] = 0;
                }
            }
        }
        
        
        
        int endhoeheunterkante = endpunktlinkekante;										//aktuelle Hˆhe der Unterkante (ver‰ndert sich und gibt am Ende die Hˆhe des letzten Mauerst¸cks an)(entspricht dem Punkt des letzen Mauerst¸cks der linken Kante)
        int zielhoeheunterkante = endpunktrechtekante;										//die gew¸nschte Hˆhe des letzten Mauerst¸cks wird gespeichert (entspricht dem Punkt des letzten Mauerst¸cks der rechten Kante) 
        int startpunktunterkante = endbreitelinkekante;										//der Punkt des ersten Mauerst¸cks wird gespeichert (entspricht der Breite des letzten Mauerst¸cks der linken Kante)
        int endpunktunterkante = endbreiterechtekante;										//der Punkt des letzten Mauerst¸cks wird gespeichert (entspricht der Breite des letzten Mauerst¸cks der rechten Kante)
        int haelfte = ((endpunktunterkante - startpunktunterkante) / 2) + startpunktunterkante;	//der Mittelpunkt zwischen dem ersten und letzten Mauerst¸ck der Unterkante wird berechnet
        
        for (int i = map.length - 1; i >= endhoeheunterkante; i--){							//die untere linke Ecke wird als leer definiert
        	for (int j = 0; j <= startpunktunterkante; j++){
        		map[i][j] = 0;
        	}
        }
        
        for (int i = map.length - 1; i >= zielhoeheunterkante; i--){						//die untere rechte Ecke wird als leer definiert
        	for (int j = map[i].length - 1; j >= endpunktunterkante; j--){
        		map[i][j] = 0;
        	}
        }
        
        for (int i = startpunktunterkante; i < endpunktunterkante; i++){					//der Bereich zwischen dem ersten und letzten Mauerst¸ck der Unterkante wird durchlaufen
            zufall = (int)(Math.random() * 9);
            
            if (i > haelfte){																//die Hˆhe der Unterkante wird ab der H‰lfte der gew¸nschten Hˆhe angeglichen
            	if (endhoeheunterkante > zielhoeheunterkante){								//wenn die aktuelle Hˆhe tiefer ist als die gew¸nschte Hˆhe, darf sie sich nicht weiter nach unten bewegen
            		if ((zufall >= 3) && (zufall <= 5))										//wenn Schritte nach unten ausgef¸hrt werden sollen, werden sie stattdessen nach oben ausgef¸hrt
            			zufall = zufall + 3;
            	}
            	else if (endhoeheunterkante < zielhoeheunterkante){							//wenn die aktuelle Hˆhe hˆher ist als die gew¸nschte Hˆhe, darf sie sich nicht weiter nach oben bewegen
            		if ((zufall >= 6) && (zufall <= 8))										//wenn Schritte nach oben ausgef¸hrt werden sollen, werden sie stattdessen nach unten ausgef¸hrt
            			zufall = zufall - 3;
            	}
            }            
            
            if ((i < startpunktunterkante + 3) || (i > (endpunktunterkante - 3))){			//die ersten und letzten 3 Mauerst¸cke sollen eine gerade Mauer ergeben
                map[endhoeheunterkante][i] = 1;
                for(int j = map.length - 1; j > endhoeheunterkante; j--)
                	map[j][i] = 0;															//der Bereich ¸ber der Mauer wird als leer definiert (wird im Folgenden h‰ufiger verwendet)
            }
            else if (i > (endpunktunterkante - 5)){											//5 Mauerst¸cke vor Ende wird die Differenz zwischen aktueller und gew¸nschter Hˆhe in einem Schritt ausgeglichen
                map[endhoeheunterkante][i] = 1;												//aufgrund der vorherigen Korrekturen, sollten keine groﬂen Spr¸nge entstehen
                for(int j = map.length - 1; j > endhoeheunterkante; j--)
                	map[j][i] = 0;
                while (endhoeheunterkante < zielhoeheunterkante)
                	map[++endhoeheunterkante][i] = 1;
                while (endhoeheunterkante > zielhoeheunterkante)
                	map[--endhoeheunterkante][i] = 1;
            }
            else if (zufall <= 2){															//mit einer Wahrscheinlichkeit von 3/9 wird ein gerades Mauerst¸ck erstellt
                map[endhoeheunterkante][i] = 1;
                for(int j = map.length - 1; j > endhoeheunterkante; j--)
                	map[j][i] = 0;
            }
            else if (zufall <= 4){															//mit einer Wahrscheinlichkeit von 2/9 wird ein Mauerst¸ck erstellt, das einen Schritt nach unten macht
                map[endhoeheunterkante][i] = 1;
                for(int j = map.length - 1; j > endhoeheunterkante; j--)
                	map[j][i] = 0;
                if (endhoeheunterkante < hoehe - 1){
                    map[++endhoeheunterkante][i] = 1;
                    map[endhoeheunterkante][++i] = 1;
                    for(int j = map.length - 1; j > endhoeheunterkante; j--)
                    	map[j][i] = 0;
                }
            }
            else if (zufall == 5){															//mit einer Wahrscheinlichkeit von 1/9 wird ein Mauerst¸ck erstellt, das zwei Schritte nach unten macht
                map[endhoeheunterkante][i] = 1;
                for(int j = map.length - 1; j > endhoeheunterkante; j--)
                	map[j][i] = 0;
                if (endhoeheunterkante < hoehe - 2){
                    map[++endhoeheunterkante][i] = 1;
                    map[++endhoeheunterkante][i] = 1;
                    map[endhoeheunterkante][++i] = 1;
                    for(int j = map.length - 1; j > endhoeheunterkante; j--)
                    	map[j][i] = 0;
                }
            }
            else if (zufall <= 7){															//mit einer Wahrscheinlichkeit von 2/9 wird ein Mauerst¸ck erstellt, das einen Schritt nach oben macht
                map[endhoeheunterkante][i] = 1;
                for(int j = map.length - 1; j > endhoeheunterkante; j--)
                	map[j][i] = 0;
                if (endhoeheunterkante > 0){
                    map[--endhoeheunterkante][i] = 1;
                    map[endhoeheunterkante][++i] = 1;
                    for(int j = map.length - 1; j > endhoeheunterkante; j--)
                    	map[j][i] = 0;
                }
            }
            else if (zufall == 8){															//mit einer Wahrscheinlichkeit von 1/9 wird ein Mauerst¸ck erstellt, das zwei Schritte nach oben macht
                map[endhoeheunterkante][i] = 1;
                for(int j = map.length - 1; j > endhoeheunterkante; j--)
                	map[j][i] = 0;
                if (endhoeheunterkante > 1){
                    map[--endhoeheunterkante][i] = 1;
                    map[--endhoeheunterkante][i] = 1;
                    map[endhoeheunterkante][++i] = 1;
                    for(int j = map.length - 1; j > endhoeheunterkante; j--)
                    	map[j][i] = 0;
                }
            }
        }
        map[endhoeheunterkante][endpunktunterkante] = 1;									//Das letzte Mauerst¸ck wird einzeln gesetzt
        
        
        
        //return map;
    }
    
    public int[][] getEbene(){
    	return map;
    }
    
    public static void Darstellen(int[][] map) {
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] == 2)
                    System.out.print("'");
                if (map[i][j] == 1)
                    System.out.print("#");
                if (map[i][j] == 0)
                    System.out.print(" ");
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
	
}
package Ebene;

public class Ebene {

	private int[][] map0, map1, map2, map3, map4, map5, map6, map7, map8, map9, aktiveMap;
	private int posHoehe, posBreite, aktiveMapInt, letzteTuer;
	
	public Ebene() {
		final int mapbreite = 60;
		final int maphoehe = 40;
		letzteTuer = 2;
        map0 = Map(maphoehe, mapbreite);
        map1 = Map(maphoehe, mapbreite);
        map2 = Map(maphoehe, mapbreite);
        map3 = Map(maphoehe, mapbreite);
        map4 = Map(maphoehe, mapbreite);
        map5 = Map(maphoehe, mapbreite);
        map6 = Map(maphoehe, mapbreite);
        map7 = Map(maphoehe, mapbreite);
        map8 = Map(maphoehe, mapbreite);
        map9 = Map(maphoehe, mapbreite);
        posHoehe = 0;
        posBreite = 0;
        aktiveMap = map0;
        aktiveMapInt = 0;
        for (int i = 0; i < aktiveMap.length; i++){
        	for (int j = 0; j < aktiveMap[i].length; j++){
            	if (aktiveMap[i][j] == 3){
            		posHoehe = i - 1;
            		posBreite = j;
            		aktiveMap[posHoehe][posBreite] = 5;
            	}
        	}
        }
    }
	
    public int[][] Map(int hoehe, int breite) {
        int[][] map = new int[hoehe][breite];
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
        
        
        int tuer, positionEingang, positionAusgang, i;

        do{
        	tuer = (int)(Math.random() * 4);
        }while (tuer == letzteTuer);
        
        switch(letzteTuer){ 
        case 0: 
            positionEingang = ((int)(Math.random() * (endpunktoberkante - startpunktoberkante - 30))) + 15;
        	if ((positionEingang > endpunktoberkante) || (positionEingang < startpunktoberkante))
        		positionEingang = startpunktoberkante + ((endpunktoberkante - startpunktoberkante) / 2);
            i = 0;
            while (map[i][positionEingang] != 1){
            	i++;
            }
            if (map[i+1][positionEingang] == 1){
            	if (map[i][positionEingang-1] == 1)
            		positionEingang--;
            	else if (map[i][positionEingang+1] == 1)
            		positionEingang++;
            }
            map[i][positionEingang] = 3;
            break; 
        case 1:
        	positionEingang = ((int)(Math.random() * (endpunktrechtekante - startpunktrechtekante - 30))) + 15;
        	if ((positionEingang > endpunktrechtekante) || (positionEingang < startpunktrechtekante))
        		positionEingang = startpunktrechtekante + ((endpunktrechtekante - startpunktrechtekante) / 2);
            i = map[positionEingang].length - 1;
            while (map[positionEingang][i] != 1){
            	i--;
            }
            if (map[positionEingang][i-1] == 1){
            	if (map[positionEingang-1][i] == 1)
            		positionEingang--;
            	else if (map[positionEingang+1][i] == 1)
            		positionEingang++;
            }
            map[positionEingang][i] = 3;
            break; 
        case 2: 
        	positionEingang = ((int)(Math.random() * (endpunktunterkante - startpunktunterkante - 30))) + 15;
        	if ((positionEingang > endpunktunterkante) || (positionEingang < startpunktunterkante))
        		positionEingang = startpunktunterkante + ((endpunktunterkante - startpunktunterkante) / 2);
            i = map.length - 1;
            while (map[i][positionEingang] != 1){
            	i--;
            }
            if (map[i-1][positionEingang] == 1){
            	if (map[i][positionEingang-1] == 1)
            		positionEingang--;
            	else if (map[i][positionEingang+1] == 1)
            		positionEingang++;
            }
            map[i][positionEingang] = 3; 
            break; 
        case 3: 
        	positionEingang = ((int)(Math.random() * (endpunktlinkekante - startpunktlinkekante - 30))) + 15;
        	if ((positionEingang > endpunktlinkekante) || (positionEingang < startpunktlinkekante))
        		positionEingang = startpunktlinkekante + ((endpunktlinkekante - startpunktlinkekante) / 2);
            i = 0;
            while (map[positionEingang][i] != 1){
            	i++;
            }
            if (map[positionEingang][i+1] == 1){
            	if (map[positionEingang-1][i] == 1)
            		positionEingang--;
            	else if (map[positionEingang+1][i] == 1)
            		positionEingang++;
            }
            map[positionEingang][i] = 3;
            break; 
        }
        
        
        switch(tuer){ 
        case 0: 
        	positionAusgang = ((int)(Math.random() * (endpunktoberkante - startpunktoberkante - 30))) + 15;
        	if ((positionAusgang > endpunktoberkante) || (positionAusgang < startpunktoberkante))
        		positionAusgang = startpunktoberkante + ((endpunktoberkante - startpunktoberkante) / 2);
            i = 0;
            while (map[i][positionAusgang] != 1){
            	i++;
            }
            if (map[i+1][positionAusgang] == 1){
            	if (map[i][positionAusgang-1] == 1)
            		positionAusgang--;
            	else if (map[i][positionAusgang+1] == 1)
            		positionAusgang++;
            }
            map[i][positionAusgang] = 4;
            break; 
        case 1: 
        	positionAusgang = ((int)(Math.random() * (endpunktrechtekante - startpunktrechtekante - 30))) + 15;
        	if ((positionAusgang > endpunktrechtekante) || (positionAusgang < startpunktrechtekante))
        		positionAusgang = startpunktrechtekante + ((endpunktrechtekante - startpunktrechtekante) / 2);
            i = map[positionAusgang].length - 1;
            while (map[positionAusgang][i] != 1){
            	i--;
            }
            if (map[positionAusgang][i-1] == 1){
            	if (map[positionAusgang-1][i] == 1)
            		positionAusgang--;
            	else if (map[positionAusgang+1][i] == 1)
            		positionAusgang++;
            }
            map[positionAusgang][i] = 4;
            break; 
        case 2: 
        	positionAusgang = ((int)(Math.random() * (endpunktunterkante - startpunktunterkante - 30))) + 15;
        	if ((positionAusgang > endpunktunterkante) || (positionAusgang < startpunktunterkante))
        		positionAusgang = startpunktunterkante + ((endpunktunterkante - startpunktunterkante) / 2);
            i = map.length - 1;
            while (map[i][positionAusgang] != 1){
            	i--;
            }
            if (map[i-1][positionAusgang] == 1){
            	if (map[i][positionAusgang-1] == 1)
            		positionAusgang--;
            	else if (map[i][positionAusgang+1] == 1)
            		positionAusgang++;
            }
            map[i][positionAusgang] = 4; 
            break; 
        case 3: 
        	positionAusgang = ((int)(Math.random() * (endpunktlinkekante - startpunktlinkekante - 30))) + 15;
        	if ((positionAusgang > endpunktlinkekante) || (positionAusgang < startpunktlinkekante))
        		positionAusgang = startpunktlinkekante + ((endpunktlinkekante - startpunktlinkekante) / 2);
            i = 0;
            while (map[positionAusgang][i] != 1){
            	i++;
            }
            if (map[positionAusgang][i+1] == 1){
            	if (map[positionAusgang-1][i] == 1)
            		positionAusgang--;
            	else if (map[positionAusgang+1][i] == 1)
            		positionAusgang++;
            }
            map[positionAusgang][i] = 4;
            break; 
        }
        
        if (tuer > 1)
        	letzteTuer = tuer - 2;
        else if (tuer < 2)
        	letzteTuer = tuer + 2;
        
        return map;
    }
    
    
    public void hoch(){
    	if (aktiveMap[posHoehe - 1][posBreite] == 2){
    		aktiveMap[posHoehe--][posBreite] = 2;
    		aktiveMap[posHoehe][posBreite] = 5;
    	}
    	else if (aktiveMap[posHoehe - 1][posBreite] == 3){
    		if (aktiveMapInt > 0){
    			aktiveMapInt--;
    			switch(aktiveMapInt){ 
    	        case 0: aktiveMap = map0; break; 
    	        case 1: aktiveMap = map1; break; 
    	        case 2: aktiveMap = map2; break; 
    	        case 3: aktiveMap = map3; break; 
    	        case 4: aktiveMap = map4; break; 
    	        case 5: aktiveMap = map5; break; 
    	        case 6: aktiveMap = map6; break; 
    	        case 7: aktiveMap = map7; break; 
    	        case 8: aktiveMap = map8; break;
    			}
    			for (int i = 0; i < aktiveMap.length; i++){
    	        	for (int j = 0; j < aktiveMap[i].length; j++){
    	        		if (aktiveMap[i][j] == 4){
    	            		posHoehe = i - 1;
    	            		posBreite = j;
    	            		aktiveMap[posHoehe][posBreite] = 5;
    	            	}
    	        	}
    	        }
    		}
    	}
    	else if (aktiveMap[posHoehe - 1][posBreite] == 4){
    		if (aktiveMapInt < 9){
    			aktiveMapInt++;
    			switch(aktiveMapInt){ 
    	        case 1: aktiveMap = map1; break; 
    	        case 2: aktiveMap = map2; break; 
    	        case 3: aktiveMap = map3; break; 
    	        case 4: aktiveMap = map4; break; 
    	        case 5: aktiveMap = map5; break; 
    	        case 6: aktiveMap = map6; break; 
    	        case 7: aktiveMap = map7; break; 
    	        case 8: aktiveMap = map8; break;
    	        case 9: aktiveMap = map9; break; 
    			}
    			for (int i = 0; i < aktiveMap.length; i++){
    	        	for (int j = 0; j < aktiveMap[i].length; j++){
    	        		if (aktiveMap[i][j] == 3){
    	            		posHoehe = i - 1;
    	            		posBreite = j;
    	            		aktiveMap[posHoehe][posBreite] = 5;
    	            	}
    	        	}
    	        }
    		}
    	}
    }
    
    public void runter(){
    	if (aktiveMap[posHoehe + 1][posBreite] == 2){
    		aktiveMap[posHoehe++][posBreite] = 2;
    		aktiveMap[posHoehe][posBreite] = 5;
    	}
    	else if (aktiveMap[posHoehe + 1][posBreite] == 3){
    		if (aktiveMapInt > 0){
    			aktiveMapInt--;
    			switch(aktiveMapInt){ 
    	        case 0: aktiveMap = map0; break; 
    	        case 1: aktiveMap = map1; break; 
    	        case 2: aktiveMap = map2; break; 
    	        case 3: aktiveMap = map3; break; 
    	        case 4: aktiveMap = map4; break; 
    	        case 5: aktiveMap = map5; break; 
    	        case 6: aktiveMap = map6; break; 
    	        case 7: aktiveMap = map7; break; 
    	        case 8: aktiveMap = map8; break;
    			}
    			for (int i = 0; i < aktiveMap.length; i++){
    	        	for (int j = 0; j < aktiveMap[i].length; j++){
    	        		if (aktiveMap[i][j] == 4){
    	            		posHoehe = i + 1;
    	            		posBreite = j;
    	            		aktiveMap[posHoehe][posBreite] = 5;
    	            	}
    	        	}
    	        }
    		}
    	}
    	else if (aktiveMap[posHoehe + 1][posBreite] == 4){
    		if (aktiveMapInt < 9){
    			aktiveMapInt++;
    			switch(aktiveMapInt){ 
    	        case 1: aktiveMap = map1; break; 
    	        case 2: aktiveMap = map2; break; 
    	        case 3: aktiveMap = map3; break; 
    	        case 4: aktiveMap = map4; break; 
    	        case 5: aktiveMap = map5; break; 
    	        case 6: aktiveMap = map6; break; 
    	        case 7: aktiveMap = map7; break; 
    	        case 8: aktiveMap = map8; break;
    	        case 9: aktiveMap = map9; break; 
    			}
    			for (int i = 0; i < aktiveMap.length; i++){
    	        	for (int j = 0; j < aktiveMap[i].length; j++){
    	        		if (aktiveMap[i][j] == 3){
    	            		posHoehe = i + 1;
    	            		posBreite = j;
    	            		aktiveMap[posHoehe][posBreite] = 5;
    	            	}
    	        	}
    	        }
    		}
    	}
    }
    
    public void links(){
    	if (aktiveMap[posHoehe][posBreite - 1] == 2){
    		aktiveMap[posHoehe][posBreite--] = 2;
    		aktiveMap[posHoehe][posBreite] = 5;
    	}
    	else if (aktiveMap[posHoehe][posBreite - 1] == 3){
    		if (aktiveMapInt > 0){
    			aktiveMapInt--;
    			switch(aktiveMapInt){ 
    	        case 0: aktiveMap = map0; break; 
    	        case 1: aktiveMap = map1; break; 
    	        case 2: aktiveMap = map2; break; 
    	        case 3: aktiveMap = map3; break; 
    	        case 4: aktiveMap = map4; break; 
    	        case 5: aktiveMap = map5; break; 
    	        case 6: aktiveMap = map6; break; 
    	        case 7: aktiveMap = map7; break; 
    	        case 8: aktiveMap = map8; break;
    			}
    			for (int i = 0; i < aktiveMap.length; i++){
    	        	for (int j = 0; j < aktiveMap[i].length; j++){
    	        		if (aktiveMap[i][j] == 4){
    	            		posHoehe = i;
    	            		posBreite = j - 1;
    	            		aktiveMap[posHoehe][posBreite] = 5;
    	            	}
    	        	}
    	        }
    		}
    	}
    	else if (aktiveMap[posHoehe][posBreite - 1] == 4){
    		if (aktiveMapInt < 9){
    			aktiveMapInt++;
    			switch(aktiveMapInt){ 
    	        case 1: aktiveMap = map1; break; 
    	        case 2: aktiveMap = map2; break; 
    	        case 3: aktiveMap = map3; break; 
    	        case 4: aktiveMap = map4; break; 
    	        case 5: aktiveMap = map5; break; 
    	        case 6: aktiveMap = map6; break; 
    	        case 7: aktiveMap = map7; break; 
    	        case 8: aktiveMap = map8; break;
    	        case 9: aktiveMap = map9; break; 
    			}
    			for (int i = 0; i < aktiveMap.length; i++){
    	        	for (int j = 0; j < aktiveMap[i].length; j++){
    	        		if (aktiveMap[i][j] == 3){
    	            		posHoehe = i;
    	            		posBreite = j - 1;
    	            		aktiveMap[posHoehe][posBreite] = 5;
    	            	}
    	        	}
    	        }
    		}
    	}
    }
    
    public void rechts(){
    	if (aktiveMap[posHoehe][posBreite + 1] == 2){
    		aktiveMap[posHoehe][posBreite++] = 2;
    		aktiveMap[posHoehe][posBreite] = 5;
    	}
    	else if (aktiveMap[posHoehe][posBreite + 1] == 3){
    		if (aktiveMapInt > 0){
    			aktiveMapInt--;
    			switch(aktiveMapInt){ 
    	        case 0: aktiveMap = map0; break; 
    	        case 1: aktiveMap = map1; break; 
    	        case 2: aktiveMap = map2; break; 
    	        case 3: aktiveMap = map3; break; 
    	        case 4: aktiveMap = map4; break; 
    	        case 5: aktiveMap = map5; break; 
    	        case 6: aktiveMap = map6; break; 
    	        case 7: aktiveMap = map7; break; 
    	        case 8: aktiveMap = map8; break;
    			}
    			for (int i = 0; i < aktiveMap.length; i++){
    	        	for (int j = 0; j < aktiveMap[i].length; j++){
    	        		if (aktiveMap[i][j] == 4){
    	            		posHoehe = i;
    	            		posBreite = j + 1;
    	            		aktiveMap[posHoehe][posBreite] = 5;
    	            	}
    	        	}
    	        }
    		}
    	}
    	else if (aktiveMap[posHoehe][posBreite + 1] == 4){
    		if (aktiveMapInt < 9){
    			aktiveMapInt++;
    			switch(aktiveMapInt){ 
    	        case 1: aktiveMap = map1; break; 
    	        case 2: aktiveMap = map2; break; 
    	        case 3: aktiveMap = map3; break; 
    	        case 4: aktiveMap = map4; break; 
    	        case 5: aktiveMap = map5; break; 
    	        case 6: aktiveMap = map6; break; 
    	        case 7: aktiveMap = map7; break; 
    	        case 8: aktiveMap = map8; break;
    	        case 9: aktiveMap = map9; break; 
    			}
    			for (int i = 0; i < aktiveMap.length; i++){
    	        	for (int j = 0; j < aktiveMap[i].length; j++){
    	        		if (aktiveMap[i][j] == 3){
    	            		posHoehe = i;
    	            		posBreite = j + 1;
    	            		aktiveMap[posHoehe][posBreite] = 5;
    	            	}
    	        	}
    	        }
    		}
    	}
    }
	
    public int[][] getSichtfeld(int hoeheAbstand, int breiteAbstand){
    	int hoeheAnzeige = hoeheAbstand * 2 + 1;
    	int breiteAnzeige = breiteAbstand * 2 + 1;
    	
    	int[][] anzeige = new int[hoeheAnzeige][breiteAnzeige];
    	
    	for (int i = 0; i < anzeige.length; i++){ 
    		for (int j = 0; j < anzeige[i].length; j++){
    			anzeige[i][j] = 0;
    		}
    	}
    	int k = 0;
    	int l = 0;
    	for (int i = (posHoehe - hoeheAbstand); i < (posHoehe + hoeheAbstand + 1); i++){ 
    		for (int j = (posBreite - breiteAbstand); j < (posBreite + breiteAbstand + 1); j++){
    			if ((i >= 0) && (i < aktiveMap.length) && (j >= 0) && (j < aktiveMap[i].length)){
    				anzeige[k][l] = aktiveMap[i][j];
    			}
    			l++;
    		}
    		l = 0;
    		k++;
    	}
		return anzeige;
	}
    
    public int getSpielerX(){
    	return posBreite;
    }
    
    public int getSpielerY(){
    	return posHoehe;
    }
    
    public int[][] getAktiveMap(){
    	return aktiveMap;
    }
}
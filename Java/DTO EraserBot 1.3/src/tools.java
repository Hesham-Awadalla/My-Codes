import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tools
{

	static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    
	public static void listDir(String path, String filetype, int FileAge) throws IOException
	{			
	    File folder = new File(path);
	    //Die Dateien (files) sowie die Ordner (folders) in dem ausgewählten Ordner "folder"
	    // ((genauer gesagt, deren Pfaden))
	    //werden in einem Array "listOfFiles" vom Typ "File" gespeichert
	    File[] listOfFiles = folder.listFiles();
	    
		String filename;
		double fileLastMod, diff;
		
		//Wichtig ist zu überprüfen, ob das File-Array ungleich null ist, da z.B. bei nicht ausreichenden
		//Berechtigungen um auf einen Ordner zuzugreifen die Methode listFiles() null zurückliefert!
		//Auch wenn (mal angenommen) der ausgewählte Ordner eine Datei (File) wäre
		if (listOfFiles != null)				
		{
			for (int i = 0; i < listOfFiles.length; i++)
			{
				// 1. Fall: Das i. Element in der listOfFiles[] ist eine Datei:
				if (listOfFiles[i].isFile())
				{
					// Dateiname sowie lastModified (in Millisekunden seit 00:00:00 GMT, 01.01.1970) werden geholt
		            filename = listOfFiles[i].getName();
		            fileLastMod = listOfFiles[i].lastModified();
		            
		            //Diff/Dateialter (in Millisekunden!) berechnen, und in "Monate" umrechnen
		            diff = (new Date().getTime() - fileLastMod)/2.628E9;
		            
		            //Suche nach Kritieren "Dateityp" und "Dateialter":		            
		            //1. Variante: Alle Dateitypen suchen
		            if (filetype == "Alle" && diff > FileAge)
	            	{
		            	//Zuletzt geändert am (mit dem deutschen Datum-/Uhrzeitformat "dd.MM.yyyy HH:mm") (s.GUI ab Z. 336)
		                GUI.listModelInfo.addElement(sdf.format(fileLastMod)+"       ");
		            	
		                //Ergebnisse (die nach Kritirien gefundenen Dateien)  (s.GUI Z. 335)
		            	GUI.listModel.addElement(listOfFiles[i]);

	            	}
		            
		            //2. Variante: Nach einem bestimmten Dateityp aus der Liste (JComboBox) suchen
		            else if (filetype != "Alle" && filename.endsWith(filetype) && diff > FileAge || filetype != "Alle" && filename.endsWith(filetype.toUpperCase()) && diff > FileAge)
            		{       
		                GUI.listModelInfo.addElement(sdf.format(fileLastMod)+"       "); 	
		            	GUI.listModel.addElement(listOfFiles[i]);

            		}
				}
				// 2. Fall: Das i. Element in der listOfFiles[] ist ein Ordner:
	            else if (listOfFiles[i].isDirectory())
	        	{
	        		//Die Methode ruft sich selbst mit dem Unterverzeichnis als Parameter auf >> "rekursive Suche"
	        		listDir(listOfFiles[i].getAbsolutePath(), filetype, FileAge);	            		
	        	}
			}
		}
			
	}
}

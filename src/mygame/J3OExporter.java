package mygame;


import com.jme3.export.binary.BinaryExporter;
import com.jme3.scene.Spatial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class J3OExporter {

public static void Save(Spatial model , String path) {
    final BinaryExporter exp = BinaryExporter.getInstance();//new BinaryExporter();
			 final File outName = new File(path);
                           
                       
			try (  FileOutputStream out = new FileOutputStream(outName))  {
				outName.createNewFile();
				exp.save(model, out);
			} 
                         catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
}
	

}
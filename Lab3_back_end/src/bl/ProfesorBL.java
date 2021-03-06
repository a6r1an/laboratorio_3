package bl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Profesor;
import eif203.util.IOServices;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author _Adrián_Prendas_
 */
public class ProfesorBL implements BaseBL<Profesor,Integer>{

    public ProfesorBL(){}
    
    @Override
    public boolean create(Profesor o) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Hashtable<Integer,Profesor> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/profesores.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("cedula"), 
                    new Profesor(
                        obj.getInt("cedula"),
                        obj.getString("nombre"),
                        obj.getInt("telefono"),
                        obj.getString("email")
                    )
                );
            }
            tablaHash.put(o.getCedula(), o);
            
            List<String> lines = new ArrayList();
            for(Integer key : tablaHash.keySet()){
                lines.add(gson.toJson(tablaHash.get(key)));
            }
            Path file = Paths.get("./../data/profesores.json");
            Files.write(file, lines, Charset.forName("UTF-8"));
     
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("*** Se almaceno correctamente ***");
        return true;
    }

    @Override
    public Profesor read(Integer key) {
        Hashtable<Integer,Profesor> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/profesores.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("cedula"), 
                    new Profesor(
                        obj.getInt("cedula"),
                        obj.getString("nombre"),
                        obj.getInt("telefono"),
                        obj.getString("email")
                    )
                );
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("*** Se cargo con exito ***");
        return tablaHash.get(key);
    }

    @Override
    public List<Profesor> read() {
        ArrayList<Profesor> listaProfesores = new ArrayList();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/profesores.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                listaProfesores.add(
                        new Profesor(
                            obj.getInt("cedula"),
                            obj.getString("nombre"),
                            obj.getInt("telefono"),
                            obj.getString("email")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("*** Se cargaron todos los registros correctamente");
        return listaProfesores;
    }

    @Override
    public boolean update(Profesor o) {
    Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Hashtable<Integer,Profesor> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/profesores.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("cedula"), 
                    new Profesor(
                        obj.getInt("cedula"),
                        obj.getString("nombre"),
                        obj.getInt("telefono"),
                        obj.getString("email")
                    )
                );
            }
            tablaHash.put(o.getCedula(), o);
            
            List<String> lines = new ArrayList();
            for(Integer key : tablaHash.keySet()){
                lines.add(gson.toJson(tablaHash.get(key)));
            }
            Path file = Paths.get("./../data/profesores.json");
            Files.write(file, lines, Charset.forName("UTF-8"));

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("*** Se modifico con exito ***");
        return true;    
    }

    @Override
    public boolean delete(Integer key) {
    Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Hashtable<Integer,Profesor> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/profesores.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("cedula"), 
                    new Profesor(
                        obj.getInt("cedula"),
                        obj.getString("nombre"),
                        obj.getInt("telefono"),
                        obj.getString("email")
                    )
                );
            }
            tablaHash.remove(key);
            List<String> lines = new ArrayList();
            for(Integer k : tablaHash.keySet()){
                lines.add(gson.toJson(tablaHash.get(k)));
            }
            Path file = Paths.get("./../data/profesores.json");
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("*** Se elimino con exito ***");
        return true;   
    }
    
}

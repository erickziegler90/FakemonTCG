package colecciones;

import java.util.ArrayList;

/**@author Axel
*
*	Esta clase pretende recibir distintos tipos de objetos, para generarles un hashMap y guardar dentro de el, por ejemplo un arrayList
*   De esta manera podemos por ejemplo asociar a una key un arrayList de cartas exactamente iguales, para que sea mas facil borrarlas.
*   Agregar luego un id a cada carta que este en nuestro stock para poder borrarlas.
*   O tambien, asignarle a una key (que podria ser el id de un usuario) varios mazos diferentes, de esta manera tendriamos varios mazos para un usuario. 
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

import cartas.Carta;

import java.util.Set;

public class ColeccionGenerica <T>{
	
	private HashMap<String, T> hMap;
	
	public ColeccionGenerica()
	{
		hMap = new HashMap<String, T>();
	}
	
	public void a�adir(String key, T elemento)
	{
		hMap.put(key, elemento);
	}
	
	public void remove(String key, T elemento)
	{
		hMap.remove(key, elemento);
	}
	
	public <Z> void TipoClase(T obj) 
	{
		System.out.println("El tipo de T es: " + obj.getClass().getName());
	}
	
	public StringBuilder listarHashMap(HashMap<String, T> hashMap)
	{
		StringBuilder builder = new StringBuilder();
		
		Set<Entry<String, T>> entry = hashMap.entrySet();
		Iterator<Entry<String, T>> itHash = entry.iterator();
		
		while(itHash.hasNext())
		{
			Entry<String, T> aux = itHash.next();
			
			builder.append(aux.getKey());
			builder.append("\n");
			builder.append(aux.getValue());
			builder.append("\n");
		}
		return builder;
	}

	public HashMap<String, T> getHashMap() {
		return hMap;
	}

	public void setHashMap(HashMap<String, T> hMap) {
		this.hMap = hMap;
	}
	
	public JSONObject persistirColeccionEnJSONObject() throws JSONException
	{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("ColeccionGenerica", getHashMap()); 
			return jsonObject;
	}
		
	public void fromJSONObject(JSONObject jsonObject) throws JSONException
	{
		try {
			HashMap<String, T> newHash;
			setHashMap(newHash = (HashMap<String, T>) jsonObject.get("ColeccionGenerica"));
			}
		
		catch(ClassCastException e) { /// le mandamos error de casteo, porque es lo que probablemente pueda suceder.
			
				System.out.println("Al igual que Coleccion, esto est� medio en beta, asi que puede fallar. Si estas leyendo esto, asi es... ERROR 404 !");
			}
	}
}

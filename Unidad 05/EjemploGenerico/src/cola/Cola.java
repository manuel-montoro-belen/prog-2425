package cola;

import java.util.ArrayList;
import java.util.List;

public class Cola <ALGO> {

  // Almacenamiento
  private List<ALGO> elementos;
  
  public Cola() {
    elementos = new ArrayList<>();
  }
  
  public void encola(ALGO a) {
    elementos.add(a);
  }
  
  public ALGO desencola() {
    ALGO a = elementos.get(0);
    elementos.remove(0);
    return a;
  }

  public void reset() {
    elementos.clear();
  }
  
  public int getLongitudCola() {
    return elementos.size();
  }
}

package com.iesebre.DAM2.examenBorrell;

public class CosesLlista {

   private String nombre;
   private String version;
   private int logotipo;
   
   public CosesLlista(String nombre, String version, int logotipo) {
      this.nombre = nombre;
      this.version = version;
      this.logotipo = logotipo;
   }
   
   public void setNombre(String nombre) { this.nombre = nombre; }
   
   public String getNombre() { return nombre; }
   
   public void setVersion(String version) { this.version = version; }
   
   public String getVersion() { return version; }
   
   public void setLogotipo(int logotipo) { this.logotipo = logotipo; }
   
   public int getLogotipo() { return logotipo; }
   
}

public class Coach {
    Deportista[] deportistas;
    String nombre;


    Coach(String nombre, Deportista[] deportistas) {
        this.nombre = nombre;
        this.deportistas = deportistas;
    }

    Coach(String nombre, Deportista deportista) {
        this.nombre = nombre;
        this.deportistas = new Deportista[] {deportista};
    }

    Coach(String nombre) {
        this.nombre = nombre;
        this.deportistas = new Deportista[]{};
    }

    public void setDeportistas(Deportista[] deportistas) {
        this.deportistas = deportistas;
    }

    public void setDeportistas(Deportista deportista) {
        this.deportistas = new Deportista[] {deportista};
    }

    public void ponerEntrenamiento() {
        for(Deportista d : this.deportistas) {
            d.entrenar();
        }
    }

    public void ponerDescansar() {
        for (Deportista d : this.deportistas) {
            d.descansar();
        }
    }

    public void ponerCompetir() {
        for (Deportista d : this.deportistas) {
            d.competir();
        }
    }
}

package ifpr.pgua.eic.exemplodatas.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exemplo {
    private int id;
    private LocalDate data;

    public Exemplo(int id, LocalDate data) {
        this.id = id;
        this.data = data;
    }

    public Exemplo(LocalDate data) {
        this.data = data;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public String toString(){
        return DateTimeFormatter.ofPattern("dd/MM/YYYY").format(data);
    }


}

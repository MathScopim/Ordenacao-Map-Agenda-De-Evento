import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventosMap {
    private Map<LocalDate, EventoMap> eventosMap;

    public AgendaEventosMap() { this.eventosMap = new HashMap<>();}

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
       EventoMap evento = new EventoMap(nome, atracao);
       eventosMap.put(data, new EventoMap(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, EventoMap> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }
    public void obterProximoEvento() {
        //Set<LocalDate> dateSet = eventosMap.keySet();
         //Collection<EventoMap> values = eventosMap.values();
        //eventosMap.get()

        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        EventoMap proximoEvento = null;
        Map<LocalDate, EventoMap> eventosTreeMap = new TreeMap<>(eventosMap);
        for(Map.Entry<LocalDate, EventoMap> entry : eventosTreeMap.entrySet()) {
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O próximo evento: " + proximoEvento + "Acontecerá na  data " + proximaData);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventosMap agendaEventosMap = new AgendaEventosMap();

        //agendaEventosMap.adicionarEvento(LocalDate.of(2024, Month.JULY, 22), "Evento 7", "Atracao 7");
        agendaEventosMap.adicionarEvento(LocalDate.of(2023, Month.MAY, 1), "Evento 2", "Atracao 2");
        agendaEventosMap.adicionarEvento(LocalDate.of(2020, Month.DECEMBER, 9), "Evento 11", "Atracao 11");
        agendaEventosMap.adicionarEvento(LocalDate.of(2027, Month.APRIL, 7), "Evento 3", "Atracao 3");

        agendaEventosMap.exibirAgenda();

        agendaEventosMap.obterProximoEvento();
    }
}

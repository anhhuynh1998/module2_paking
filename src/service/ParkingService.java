package service;

import model.Ticket;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    private final static String path = "data\\information.csv";
    private final static String lichSu = "lichsu.csv";
    public ParkingService() {

    }

    public List<Ticket> findAll() {
        List<Ticket> tickets = new ArrayList<>();
        List<String> lines = CSVUtils.read(path);
        for (String line : lines) {
            Ticket ticket = Ticket.parse(line);
            tickets.add(ticket);
        }
        return tickets;
    }
    public List<Ticket> findAllHistory() {
        List<Ticket> newLichsu = new ArrayList<>();
        List<String> lines = CSVUtils.read(lichSu);
        for (String line : lines) {
            Ticket ticket = Ticket.parse(line);
            newLichsu.add(ticket);
        }
        return newLichsu;
    }
    public void add(Ticket newTicket) {
        List<Ticket> tickets = findAll();
        tickets.add(newTicket);
        CSVUtils.write(path, tickets);
    }

    public void update(Ticket newTicket) {
        findAll().add(newTicket);
    }
}

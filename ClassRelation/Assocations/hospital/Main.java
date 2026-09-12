import java.util.*;



class Doctor {

    private String name;
    private String specialization;

    private List<Appointment> appointments = new ArrayList<>();

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void addAppointment(Appointment newAppointment) {

        if (!appointments.contains(newAppointment)) {
            appointments.add(newAppointment);
        }
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}


class Patient {

    private String name;

    private List<Appointment> appointments = new ArrayList<>();

    public Patient(String name) {
        this.name = name;
    }

    public void addAppointment(Appointment newAppointment) {

        if (!appointments.contains(newAppointment)) {
            appointments.add(newAppointment);
        }
    }

    public String getName() {
        return name;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}


class Room {

    private String number;
    private int floor;

    public Room(String number, int floor) {
        this.number = number;
        this.floor = floor;
    }

    public String getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }
}


class Appointment {

    private Doctor doctor;
    private Patient patient;
    private Room room;
    private String time;

    public Appointment(
            Doctor doctor,
            Patient patient,
            Room room,
            String time) {

        this.doctor = doctor;
        this.patient = patient;
        this.room = room;
        this.time = time;

        doctor.addAppointment(this);
        patient.addAppointment(this);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Room getRoom() {
        return room;
    }

    public String getTime() {
        return time;
    }
}

public class Main {


    public static void main(String[] args) {

        Doctor doctor =new Doctor("Dr. Rahul", "Cardiology");

        Patient patient=new Patient("Sachin");

        Room room =new Room("101", 1);

        Appointment appointment =new Appointment(
        doctor,
        patient,
        room,
        "10:00 AM" );

    

         System.out.println(
                "Doctor: " +
                appointment.getDoctor().getName()
        );

        System.out.println(
                "Patient: " +
                appointment.getPatient().getName()
        );

        System.out.println(
                "Room: " +
                appointment.getRoom().getNumber()
        );

        System.out.println(
                "Time: " +
                appointment.getTime()
        );
        
    }
}
package Server;

import Database.Admin;
import Database.VisaApplication;
import Database.VisaApplyer;

import java.io.Serializable;
import java.util.ArrayList;

public class DataObject implements Serializable {
    private Admin admin;
    private ArrayList<VisaApplication> visaApplications;
    private VisaApplyer applyer;
    private String message;
    private char operation;

    public DataObject(Admin a) {
        this.setNull();
        this.admin = a;
    }

    public DataObject(VisaApplyer v) {
        this.setNull();
        this.applyer = v;
    }

    public DataObject(VisaApplication v) {
        this.setNull();
        this.visaApplications = new ArrayList<>();
        this.visaApplications.add(v);
    }

    public DataObject(ArrayList<VisaApplication> a) {
        this.setNull();
        this.visaApplications = a;
    }

    public DataObject(String m) {
        this.setNull();
        this.message = m;
    }

    public DataObject(Admin a,ArrayList<VisaApplication> arr) {
        this.setNull();
        this.admin = a;
        this.visaApplications = arr;
    }

    public DataObject(Admin a,String m) {
        this.setNull();
        this.admin = a;
        this.message = m;
    }

    public DataObject(VisaApplyer v, String registration_successful) {
        this.setNull();
        this.applyer = v;
        this.message = registration_successful;
    }

    private void setNull() {
        this.visaApplications = null;
        this.message = null;
        this.admin = null;
        this.applyer = null;
        this.operation = 'Z';
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public ArrayList<VisaApplication> getApplies() {
        return visaApplications;
    }

    public String getMessage() {
        return message;
    }

    public char getOperation() {
        return this.operation;
    }

    public VisaApplyer getApplyer() {
        return this.applyer;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setApplies(VisaApplyer appliers) {
        this.applyer = appliers;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOperation(char c) {
        this.operation = c;
    }

    public VisaApplication getVisaApplication() {
        return this.visaApplications.get(0);
    }

    public void setVisaApplications(ArrayList<VisaApplication> v) {
        this.visaApplications = v;
    }
}
